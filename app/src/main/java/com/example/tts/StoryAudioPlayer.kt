package com.example.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Locale

enum class EnglishAccent(val label: String, val locale: Locale) {
    US_NATIVE("US Native", Locale.US),
    UK_NATIVE("UK Native", Locale.UK)
}

class StoryAudioPlayer(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)

    var isReady by mutableStateOf(false)
        private set

    var isPlaying by mutableStateOf(false)
        private set

    var speechRate by mutableFloatStateOf(1.0f)
        private set

    var currentAccent by mutableStateOf(EnglishAccent.US_NATIVE)
        private set

    var currentSentenceIndex by mutableStateOf(-1)
        private set
    var currentWordRange by mutableStateOf<IntRange?>(null)
        private set

    private var sentences: List<String> = emptyList()

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            applyNativeEnglishVoice(currentAccent)
            isReady = true
            setupProgressListener()
        }
    }

    fun setAccent(accent: EnglishAccent) {
        currentAccent = accent
        applyNativeEnglishVoice(accent)
    }

    private fun applyNativeEnglishVoice(accent: EnglishAccent) {
        tts?.let { engine ->
            val result = engine.setLanguage(accent.locale)
            if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                // Find high-quality natural voice for the target locale if available
                try {
                    val voices = engine.voices
                    if (!voices.isNullOrEmpty()) {
                        val matchingVoice = voices
                            .filter { it.locale.language == "en" && it.locale.country.equals(accent.locale.country, ignoreCase = true) }
                            .sortedWith(
                                compareByDescending<Voice> { it.quality }
                                    .thenByDescending { !it.isNetworkConnectionRequired }
                            )
                            .firstOrNull()

                        if (matchingVoice != null) {
                            engine.voice = matchingVoice
                        }
                    }
                } catch (e: Exception) {
                    // Fallback to default setLanguage
                }
                engine.setPitch(1.0f)
                engine.setSpeechRate(speechRate)
            }
        }
    }

    private fun setupProgressListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                isPlaying = true
                utteranceId?.toIntOrNull()?.let { idx ->
                    currentSentenceIndex = idx
                    currentWordRange = null
                }
            }

            override fun onRangeStart(utteranceId: String?, start: Int, end: Int, frame: Int) {
                super.onRangeStart(utteranceId, start, end, frame)
                utteranceId?.toIntOrNull()?.let { idx ->
                    currentSentenceIndex = idx
                    currentWordRange = start until end
                }
            }

            override fun onDone(utteranceId: String?) {
                if (utteranceId == "entire_story") {
                    isPlaying = false
                    currentWordRange = null
                }
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                isPlaying = false
                currentWordRange = null
            }
        })
    }

    fun playText(text: String) {
        if (!isReady || tts == null) return

        stop()
        sentences = emptyList()
        tts?.setSpeechRate(speechRate)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "entire_story")
        isPlaying = true
    }

    fun playSingleWord(word: String) {
        if (!isReady || tts == null) return
        tts?.setSpeechRate(speechRate)
        tts?.speak(word, TextToSpeech.QUEUE_FLUSH, null, "single_word")
    }

    fun setSpeed(rate: Float) {
        speechRate = rate
        tts?.setSpeechRate(rate)
    }

    fun stop() {
        if (tts != null) {
            tts?.stop()
            isPlaying = false
            currentSentenceIndex = -1
            currentWordRange = null
        }
    }

    fun shutdown() {
        stop()
        tts?.shutdown()
        tts = null
    }
}
