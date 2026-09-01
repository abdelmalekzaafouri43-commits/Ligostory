package com.example.parser

import com.example.data.ParsedPart

object StoryMarkupParser {
    // Matches [L:word](info), [T:verb](info), [C:word](info), [N:word](info), [ADJ:word](info), [ADV:word](info), [P:word](info), [S:Structure:clause](info) or [S:clause](info)
    private val tagRegex = Regex("""\[(L|T|C|N|ADJ|ADV|P|S)(?::([^:\]]+))?(?::([^\]]+))?\]\(([^)]+)\)""")

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
            val param1 = match.groupValues[2].trim()
            val param2 = match.groupValues[3].trim()
            val rawAnnotation = match.groupValues[4].trim()

            when (type) {
                "L" -> {
                    val word = param1
                    val levelMatch = Regex("""\b([ABC][12])\b""").find(rawAnnotation)
                    val level = levelMatch?.value ?: "Lexicon"
                    val definition = rawAnnotation.replace(Regex("""\s*-\s*[ABC][12]"""), "").trim()
                    result.add(ParsedPart.Lexicon(word = word, definition = definition, level = level))
                }
                "T" -> {
                    val word = param1
                    val parts = rawAnnotation.split("-", limit = 2)
                    val tenseName = parts.getOrNull(0)?.trim() ?: "Verb Tense"
                    val explanation = parts.getOrNull(1)?.trim() ?: rawAnnotation
                    result.add(ParsedPart.VerbTense(word = word, tenseName = tenseName, explanation = explanation))
                }
                "C" -> {
                    val word = param1
                    result.add(ParsedPart.Conjunction(word = word, role = rawAnnotation))
                }
                "N" -> {
                    val word = param1
                    result.add(ParsedPart.Noun(word = word, role = "Noun / Subject", explanation = rawAnnotation))
                }
                "ADJ" -> {
                    val word = param1
                    result.add(ParsedPart.Adjective(word = word, explanation = rawAnnotation))
                }
                "ADV" -> {
                    val word = param1
                    result.add(ParsedPart.Adverb(word = word, explanation = rawAnnotation))
                }
                "P" -> {
                    val word = param1
                    result.add(ParsedPart.Preposition(word = word, explanation = rawAnnotation))
                }
                "S" -> {
                    // Could be [S:Relative Clause:clause text](explanation) or [S:clause text](Structure Name - explanation)
                    val structureType: String
                    val clauseText: String
                    if (param2.isNotEmpty()) {
                        structureType = param1
                        clauseText = param2
                    } else {
                        val parts = rawAnnotation.split("-", limit = 2)
                        if (parts.size == 2) {
                            structureType = parts[0].trim()
                        } else {
                            structureType = "Clause / Sentence Structure"
                        }
                        clauseText = param1
                    }
                    result.add(
                        ParsedPart.SentenceStructure(
                            text = clauseText,
                            structureType = structureType,
                            explanation = rawAnnotation
                        )
                    )
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
            val param1 = matchResult.groupValues[2].trim()
            val param2 = matchResult.groupValues[3].trim()
            if (param2.isNotEmpty()) param2 else param1
        }
    }
}

