package com.example.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

data class WordDefinition(
    val word: String,
    val phonetic: String,
    val partOfSpeech: String,
    val definition: String,
    val example: String = ""
)

object DictionaryApi {
    suspend fun fetchDefinition(word: String): WordDefinition? = withContext(Dispatchers.IO) {
        try {
            val cleanWord = word.filter { it.isLetter() }.lowercase()
            if (cleanWord.isBlank()) return@withContext null
            
            val url = URL("https://api.dictionaryapi.dev/api/v2/entries/en/$cleanWord")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            if (connection.responseCode == 200) {
                val response = connection.inputStream.bufferedReader().readText()
                val jsonArray = JSONArray(response)
                if (jsonArray.length() > 0) {
                    val firstEntry = jsonArray.getJSONObject(0)
                    val fetchedWord = firstEntry.optString("word", cleanWord)
                    var phonetic = firstEntry.optString("phonetic", "")
                    
                    if (phonetic.isBlank()) {
                        val phoneticsArray = firstEntry.optJSONArray("phonetics")
                        if (phoneticsArray != null && phoneticsArray.length() > 0) {
                            for (i in 0 until phoneticsArray.length()) {
                                val pText = phoneticsArray.getJSONObject(i).optString("text", "")
                                if (pText.isNotBlank()) {
                                    phonetic = pText
                                    break
                                }
                            }
                        }
                    }

                    val meaningsArray = firstEntry.optJSONArray("meanings")
                    if (meaningsArray != null && meaningsArray.length() > 0) {
                        val firstMeaning = meaningsArray.getJSONObject(0)
                        val partOfSpeech = firstMeaning.optString("partOfSpeech", "")
                        
                        val defsArray = firstMeaning.optJSONArray("definitions")
                        if (defsArray != null && defsArray.length() > 0) {
                            val defObj = defsArray.getJSONObject(0)
                            val definition = defObj.optString("definition", "")
                            val example = defObj.optString("example", "")
                            
                            return@withContext WordDefinition(
                                word = fetchedWord,
                                phonetic = phonetic,
                                partOfSpeech = partOfSpeech,
                                definition = definition,
                                example = example
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return@withContext null
    }
}
