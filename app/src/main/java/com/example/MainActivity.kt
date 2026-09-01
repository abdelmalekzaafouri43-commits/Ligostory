package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.api.GeminiStoryGenerator
import com.example.api.ImagenStoryIllustrator
import com.example.data.CefrLevel
import com.example.data.ParsedPart
import com.example.data.PresetStories
import com.example.data.StoryData
import com.example.data.StoryTheme
import com.example.data.db.AppDatabase
import com.example.data.repository.StoryCacheRepository
import com.example.parser.StoryMarkupParser
import com.example.tts.StoryAudioPlayer
import com.example.ui.components.AnnotationBottomSheet
import com.example.ui.components.Bottom75Section
import com.example.ui.components.StorySelectorDialog
import com.example.ui.components.Top25Section
import com.example.ui.theme.AppThemePalette
import com.example.ui.theme.LingoStoryTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Hide system UI for true immersive full screen
        androidx.core.view.WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(androidx.core.view.WindowInsetsCompat.Type.systemBars())
            systemBarsBehavior = androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        setContent {
            val systemDark = androidx.compose.foundation.isSystemInDarkTheme()
            var isDarkTheme by remember { mutableStateOf(systemDark) }
            var currentPalette by remember { mutableStateOf(AppThemePalette.SAPPHIRE) }
            
            LingoStoryTheme(
                darkTheme = isDarkTheme,
                palette = currentPalette
            ) {
                MainAppScreen(
                    isDarkTheme = isDarkTheme,
                    onToggleDarkTheme = { isDarkTheme = !isDarkTheme },
                    currentPalette = currentPalette,
                    onSelectPalette = { currentPalette = it }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(
    isDarkTheme: Boolean = false,
    onToggleDarkTheme: () -> Unit = {},
    currentPalette: AppThemePalette = AppThemePalette.SAPPHIRE,
    onSelectPalette: (AppThemePalette) -> Unit = {}
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Room Database & Cache Repository
    val database = remember { AppDatabase.getDatabase(context) }
    val cacheRepository = remember { StoryCacheRepository(database.storyDao()) }
    val cachedStories by cacheRepository.cachedStories.collectAsStateWithLifecycle(initialValue = emptyList())

    // TTS Audio Engine
    val audioPlayer = remember { StoryAudioPlayer(context) }
    DisposableEffect(Unit) {
        onDispose {
            audioPlayer.shutdown()
        }
    }

    // Active Story & Parsed Parts
    var activeStory by remember { mutableStateOf(PresetStories.defaultStory) }
    var parsedParts by remember { mutableStateOf(StoryMarkupParser.parse(activeStory.rawStoryText)) }

    // Update parsed parts & automatically cache read story into Room for offline access
    LaunchedEffect(activeStory) {
        parsedParts = StoryMarkupParser.parse(activeStory.rawStoryText)
        audioPlayer.stop()
        // Save read story to Room local cache
        cacheRepository.cacheStory(activeStory)
    }

    // Modal Sheet State for Word Annotations
    var selectedPart by remember { mutableStateOf<ParsedPart?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    // Library / AI Story Selector Dialog State
    var showSelectorDialog by remember { mutableStateOf(false) }
    var isGeneratingAiStory by remember { mutableStateOf(false) }
    var isGeneratingImagenArt by remember { mutableStateOf(false) }
    val savedStories = remember { mutableStateListOf<StoryData>() }
    
    val scrollState = rememberScrollState()
    val plainText = remember(activeStory) { StoryMarkupParser.getPlainText(activeStory.rawStoryText) }
    val readingProgress by remember(audioPlayer.isPlaying, audioPlayer.currentWordRange, scrollState.value, scrollState.maxValue, plainText) {
        derivedStateOf {
            if (audioPlayer.isPlaying && audioPlayer.currentWordRange != null && plainText.isNotEmpty()) {
                (audioPlayer.currentWordRange!!.last.toFloat() / plainText.length.toFloat()).coerceIn(0f, 1f)
            } else {
                if (scrollState.maxValue > 0) {
                    (scrollState.value.toFloat() / scrollState.maxValue.toFloat()).coerceIn(0f, 1f)
                } else {
                    0f
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // TOP 25% SECTION: Title, Level, Theme, Image Prompt / Banner
            Top25Section(
                story = activeStory,
                onOpenLibrary = { showSelectorDialog = true },
                onSaveStory = {
                    scope.launch {
                        cacheRepository.cacheStory(activeStory)
                        snackbarHostState.showSnackbar("💾 Story saved & cached locally in Room for offline access!")
                    }
                },
                onSaveImageToGallery = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Saving image to gallery...")
                        val result = com.example.util.ImageSaverUtil.saveStoryImageToGallery(context, activeStory, "Abdelmalek Zaafouri")
                        result.onSuccess { msg ->
                            snackbarHostState.showSnackbar("🖼️ $msg")
                        }.onFailure { error ->
                            snackbarHostState.showSnackbar("Failed to save image: ${error.message}")
                        }
                    }
                },
                onGenerateAiStory = {
                    scope.launch {
                        isGeneratingAiStory = true
                        val result = GeminiStoryGenerator.generateStory(activeStory.level, activeStory.theme)
                        isGeneratingAiStory = false
                        result.onSuccess { newStory ->
                            activeStory = newStory
                            cacheRepository.cacheStory(newStory)
                            snackbarHostState.showSnackbar("✨ New AI Story generated and cached locally!")
                            
                            // Automatically trigger Imagen chapter illustration in the background
                            launch {
                                isGeneratingImagenArt = true
                                val imageRes = ImagenStoryIllustrator.generateChapterIllustration(newStory)
                                isGeneratingImagenArt = false
                                imageRes.onSuccess { illust ->
                                    val withImage = newStory.copy(
                                        generatedImageBase64 = illust.imageBase64,
                                        generatedImageUrl = illust.imageUrl
                                    )
                                    activeStory = withImage
                                    cacheRepository.cacheStory(withImage)
                                }
                            }
                        }.onFailure { error ->
                            snackbarHostState.showSnackbar("Generation note: ${error.message ?: "Failed to generate AI story"}")
                        }
                    }
                },
                onGenerateImagenArt = {
                    scope.launch {
                        isGeneratingImagenArt = true
                        val result = ImagenStoryIllustrator.generateChapterIllustration(activeStory)
                        isGeneratingImagenArt = false
                        result.onSuccess { illust ->
                            val updated = activeStory.copy(
                                generatedImageBase64 = illust.imageBase64,
                                generatedImageUrl = illust.imageUrl
                            )
                            activeStory = updated
                            cacheRepository.cacheStory(updated)
                            snackbarHostState.showSnackbar("🎨 Chapter illustrated with ${illust.modelName}!")
                        }.onFailure { error ->
                            snackbarHostState.showSnackbar("Imagen notice: ${error.message ?: "Could not generate illustration"}")
                        }
                    }
                },
                isGenerating = isGeneratingAiStory,
                isGeneratingImage = isGeneratingImagenArt,
                readingProgress = readingProgress,
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = onToggleDarkTheme,
                currentPalette = currentPalette,
                onSelectPalette = onSelectPalette,
                modifier = Modifier.weight(0.25f)
            )

            // BOTTOM 75% SECTION: Audio Controls, Interactive Story Reader, Quiz
            Bottom75Section(
                story = activeStory,
                parsedParts = parsedParts,
                onAnnotationClick = { part ->
                    selectedPart = part
                },
                isPlayingAudio = audioPlayer.isPlaying,
                currentWordRange = audioPlayer.currentWordRange,
                onToggleAudio = {
                    if (audioPlayer.isPlaying) {
                        audioPlayer.stop()
                    } else {
                        val plainText = StoryMarkupParser.getPlainText(activeStory.rawStoryText)
                        audioPlayer.playText(plainText)
                    }
                },
                onStopAudio = {
                    audioPlayer.stop()
                },
                speechRate = audioPlayer.speechRate,
                onChangeSpeechRate = { newRate ->
                    audioPlayer.setSpeed(newRate)
                },
                currentAccent = audioPlayer.currentAccent,
                onChangeAccent = { newAccent ->
                    audioPlayer.setAccent(newAccent)
                },
                modifier = Modifier.weight(0.75f)
            )
        }

        // Annotation Detail Bottom Sheet
        if (selectedPart != null) {
            AnnotationBottomSheet(
                part = selectedPart,
                onDismiss = { selectedPart = null },
                onSpeakWord = { word ->
                    audioPlayer.playSingleWord(word)
                },
                sheetState = sheetState
            )
        }

        // Story Library & Selector Dialog
        if (showSelectorDialog) {
            StorySelectorDialog(
                currentStory = activeStory,
                savedStories = savedStories,
                cachedStories = cachedStories,
                onSelectStory = { story ->
                    activeStory = story
                },
                onDeleteCachedStory = { id ->
                    scope.launch {
                        cacheRepository.deleteCachedStory(id)
                        snackbarHostState.showSnackbar("🗑️ Removed story from offline cache.")
                    }
                },
                onClearCache = {
                    scope.launch {
                        cacheRepository.clearAllCache()
                        snackbarHostState.showSnackbar("🧹 Offline cache cleared.")
                    }
                },
                onGenerateAiStory = { level, theme ->
                    scope.launch {
                        isGeneratingAiStory = true
                        val result = GeminiStoryGenerator.generateStory(level, theme)
                        isGeneratingAiStory = false
                        result.onSuccess { newStory ->
                            activeStory = newStory
                            cacheRepository.cacheStory(newStory)
                            showSelectorDialog = false
                            snackbarHostState.showSnackbar("✨ New AI Story created & cached for ${level.label} (${theme.label})!")

                            // Automatically trigger Imagen chapter illustration
                            launch {
                                isGeneratingImagenArt = true
                                val imageRes = ImagenStoryIllustrator.generateChapterIllustration(newStory)
                                isGeneratingImagenArt = false
                                imageRes.onSuccess { illust ->
                                    val withImage = newStory.copy(
                                        generatedImageBase64 = illust.imageBase64,
                                        generatedImageUrl = illust.imageUrl
                                    )
                                    activeStory = withImage
                                    cacheRepository.cacheStory(withImage)
                                }
                            }
                        }.onFailure { error ->
                            snackbarHostState.showSnackbar("Could not generate story: ${error.localizedMessage}")
                        }
                    }
                },
                isGenerating = isGeneratingAiStory,
                onDismiss = { showSelectorDialog = false }
            )
        }
    }
}
