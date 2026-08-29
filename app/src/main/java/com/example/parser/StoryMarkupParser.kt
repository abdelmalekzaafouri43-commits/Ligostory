package com.example.parser

import com.example.data.ParsedPart

object StoryMarkupParser {
    // Matches [L:word](definition), [T:verb](tense + info), [C:word](role)
    private val tagRegex = Regex("""\[([LTC]):([^\]]+)\]\(([^)]+)\)""")

    fun parse(rawText: String): List<ParsedPart> {
        val result = mutableListOf<ParsedPart>()
        var currentIndex = 0

        for (match in tagRegex.findAll(rawText)) {
            val start = match.range.first
            val end = match.range.last + 1

            if (start > currentIndex) {
                val prefix = rawText.substring(currentIndex, start)
                if (prefix.isNotEmpty()) {
                    prefix.split(Regex("""(?<=\s)""")).filter { it.isNotEmpty() }.forEach {
                        result.add(ParsedPart.NormalText(it))
                    }
                }
            }

            val type = match.groupValues[1]
            val word = match.groupValues[2].trim()
            val rawAnnotation = match.groupValues[3].trim()

            when (type) {
                "L" -> {
                    // Check if annotation contains level like " - A2" or " (B1)"
                    val levelMatch = Regex("""\b([ABC][12])\b""").find(rawAnnotation)
                    val level = levelMatch?.value ?: "Lexique"
                    val definition = rawAnnotation.replace(Regex("""\s*-\s*[ABC][12]"""), "").trim()
                    result.add(ParsedPart.Lexicon(word = word, definition = definition, level = level))
                }
                "T" -> {
                    val parts = rawAnnotation.split("-", limit = 2)
                    val tenseName = parts.getOrNull(0)?.trim() ?: "Verb Tense"
                    val explanation = parts.getOrNull(1)?.trim() ?: rawAnnotation
                    result.add(ParsedPart.VerbTense(word = word, tenseName = tenseName, explanation = explanation))
                }
                "C" -> {
                    result.add(ParsedPart.Conjunction(word = word, role = rawAnnotation))
                }
            }

            currentIndex = end
        }

        if (currentIndex < rawText.length) {
            val tail = rawText.substring(currentIndex)
            if (tail.isNotEmpty()) {
                tail.split(Regex("""(?<=\s)""")).filter { it.isNotEmpty() }.forEach {
                    result.add(ParsedPart.NormalText(it))
                }
            }
        }

        return result
    }

    // Helper to get clean plain text without markup (useful for Text-To-Speech)
    fun getPlainText(rawText: String): String {
        return tagRegex.replace(rawText) { matchResult ->
            matchResult.groupValues[2] // Just the word
        }
    }
}
