package com.example.data

enum class CefrLevel(val label: String, val badgeColorHex: Long) {
    A2("Beginner A2", 0xFF10B981),
    B1("Intermediate B1", 0xFF3B82F6),
    C1("Advanced C1", 0xFF8B5CF6)
}

enum class StoryTheme(val label: String, val iconName: String) {
    TRAVEL("Travel", "flight"),
    WORK("Work & Career", "work"),
    DAILY_LIFE("Daily Life", "home"),
    TECHNOLOGY("Technology", "computer"),
    CULTURE("Culture & Arts", "theater_comedy"),
    NATURE("Nature & Adventure", "forest")
}

enum class GrammarCategory(
    val id: String,
    val label: String,
    val shortBadge: String,
    val iconEmoji: String
) {
    ALL("all", "All Tags", "All", "✨"),
    NOUN("noun", "Nouns", "Noun", "🟣"),
    VERB_TENSE("verb_tense", "Verbs & Tenses", "Verb", "🔵"),
    ADJECTIVE("adjective", "Adjectives", "Adj", "🟢"),
    ADVERB("adverb", "Adverbs", "Adv", "🔷"),
    PREPOSITION("preposition", "Prepositions", "Prep", "🌸"),
    CONJUNCTION("conjunction", "Conjunctions", "Conj", "🟠"),
    SENTENCE_STRUCTURE("sentence_structure", "Sentence Structures", "Clause", "🔴"),
    VOCABULARY("vocabulary", "Vocabulary", "Vocab", "🟡")
}

sealed class ParsedPart {
    data class NormalText(val text: String) : ParsedPart()
    
    data class Lexicon(
        val word: String,
        val definition: String,
        val level: String
    ) : ParsedPart()
    
    data class VerbTense(
        val word: String,
        val tenseName: String,
        val explanation: String
    ) : ParsedPart()
    
    data class Conjunction(
        val word: String,
        val role: String
    ) : ParsedPart()

    data class Noun(
        val word: String,
        val role: String = "Noun / Subject",
        val explanation: String
    ) : ParsedPart()

    data class Adjective(
        val word: String,
        val modifiedNoun: String = "",
        val explanation: String
    ) : ParsedPart()

    data class Adverb(
        val word: String,
        val type: String = "Manner / Time / Degree",
        val explanation: String
    ) : ParsedPart()

    data class Preposition(
        val word: String,
        val phrase: String = "",
        val explanation: String
    ) : ParsedPart()

    data class SentenceStructure(
        val text: String,
        val structureType: String,
        val subject: String = "",
        val verb: String = "",
        val complement: String = "",
        val explanation: String
    ) : ParsedPart()

    val grammarCategory: GrammarCategory?
        get() = when (this) {
            is Lexicon -> GrammarCategory.VOCABULARY
            is VerbTense -> GrammarCategory.VERB_TENSE
            is Conjunction -> GrammarCategory.CONJUNCTION
            is Noun -> GrammarCategory.NOUN
            is Adjective -> GrammarCategory.ADJECTIVE
            is Adverb -> GrammarCategory.ADVERB
            is Preposition -> GrammarCategory.PREPOSITION
            is SentenceStructure -> GrammarCategory.SENTENCE_STRUCTURE
            is NormalText -> null
        }

    val displayString: String
        get() = when (this) {
            is NormalText -> text
            is Lexicon -> word
            is VerbTense -> word
            is Conjunction -> word
            is Noun -> word
            is Adjective -> word
            is Adverb -> word
            is Preposition -> word
            is SentenceStructure -> text
        }
}


data class QuizQuestion(
    val question: String,
    val options: List<String>, // Exactly 3 options A, B, C
    val correctAnswerIndex: Int, // 0, 1, or 2
    val explanation: String
)

data class StoryData(
    val id: String,
    val title: String,
    val level: CefrLevel,
    val theme: StoryTheme,
    val imagePrompt: String,
    val localDrawableRes: Int? = null,
    val rawStoryText: String,
    val quizQuestions: List<QuizQuestion>,
    val morale: String = "",
    val generatedImageBase64: String? = null,
    val generatedImageUrl: String? = null
)
