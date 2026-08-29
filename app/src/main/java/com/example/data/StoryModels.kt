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
    val morale: String = ""
)
