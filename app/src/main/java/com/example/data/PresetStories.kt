package com.example.data

import com.example.R

object PresetStories {

    val defaultStory = StoryData(
        id = "travel_a2_1",
        title = "A First Journey to London",
        level = CefrLevel.A2,
        theme = StoryTheme.TRAVEL,
        imagePrompt = "A cozy cafe in London with a traveler looking at a train map on a table, soft warm ambient lighting, vibrant digital art style.",
        localDrawableRes = R.drawable.hero_story_banner_1787934764195,
        rawStoryText = """Tom [T:wakes up](Present Simple - Habits and routines) early today [C:because](Shows cause or reason) it is his first day in London. He [T:feels](Present Simple - Current state) a bit [L:nervous](Anxious or worried - A2) about navigating the underground, [C:but](Shows contrast) his enthusiasm keeps him going. After a [L:hearty](Substantial and satisfying - A2) breakfast at a local cafe, he decides to visit Big Ben. [C:While](Shows simultaneous action) he is waiting for the bus, an elderly lady kindly offers directions. She [T:explains](Present Simple - General truth) the city route with great detail. Tom thanks her warmly [C:and](Connects supporting ideas) walks towards the station. He feels [L:confident](Feeling sure of oneself - A2) that this trip will be unforgettable.""",
        quizQuestions = listOf(QuizQuestion(
            question = "Why does Tom wake up early?",
            options = listOf("A) Because he has a flight to catch", "B) Because it is his first day in London", "C) Because his alarm rings continuously"),
            correctAnswerIndex = 1,
            explanation = "The text states: 'Tom wakes up early today because it is his first day in London.'"
        ), QuizQuestion(
            question = "What verb tense is used in 'Tom wakes up early'?",
            options = listOf("A) Past Continuous", "B) Present Simple", "C) Present Perfect"),
            correctAnswerIndex = 1,
            explanation = "'wakes up' is in the Present Simple tense, used for habits and routines."
        ), QuizQuestion(
            question = "What role does the conjunction 'because' serve in the sentence?",
            options = listOf("A) Shows contrast between two ideas", "B) Shows the cause or reason for an action", "C) Adds an additional listing item"),
            correctAnswerIndex = 1,
            explanation = "'because' is a conjunction used to state cause or reason."
        ))
    )

    val stories: List<StoryData> = listOf(
        defaultStory,

        StoryData(
            id = "work_b1_1",
            title = "The Morning Pitch Presentation",
            level = CefrLevel.B1,
            theme = StoryTheme.WORK,
            imagePrompt = "A modern glass office room with a professional giving a presentation with charts on a screen, clean corporate lighting.",
            localDrawableRes = R.drawable.hero_story_banner_1787934764195,
            rawStoryText = """Sarah [T:has been rehearsing](Present Perfect Continuous - Action started in past and continuing to present) her slides all night [C:so that](Shows purpose) she can deliver a flawless pitch to the executive board. Although she felt slightly [L:overwhelmed](Feeling crushed by weight of responsibilities - B1) by the strict deadline, her team provided invaluable research. [C:In order to](Shows intention) engage her audience, she begins her presentation with a compelling case study. The board members [T:nodded](Past Simple - Completed action in past) attentively throughout her talk. [C:Furthermore](Adds additional supporting information), the chief executive asked several thoughtful questions regarding scalability. Sarah answered each inquiry with [L:poise](Calm dignity and self-assurance - B1) and conviction, securing the contract successfully.""",
            quizQuestions = listOf(QuizQuestion(
                question = "Why did Sarah rehearse her slides all night?",
                options = listOf("A) To study for a university exam", "B) So that she could deliver a flawless pitch", "C) To finish writing a novel"),
                correctAnswerIndex = 1,
                explanation = "The text states 'Sarah has been rehearsing her slides all night so that she can deliver a flawless pitch'."
            ), QuizQuestion(
                question = "What does the lexicon 'poise' mean in context?",
                options = listOf("A) Sudden anger and panic", "B) Calm dignity and self-assurance", "C) Hesitation and uncertainty"),
                correctAnswerIndex = 1,
                explanation = "'Poise' refers to maintaining calm dignity and composure."
            ), QuizQuestion(
                question = "What is the function of the conjunction 'Furthermore'?",
                options = listOf("A) To state a contradiction", "B) To add additional supporting information", "C) To indicate a time sequence"),
                correctAnswerIndex = 1,
                explanation = "'Furthermore' is an additive conjunction introducing extra supporting points."
            ))
        ),

        StoryData(
            id = "tech_c1_1",
            title = "Ethics in the Age of Synthetic Intelligence",
            level = CefrLevel.C1,
            theme = StoryTheme.TECHNOLOGY,
            imagePrompt = "Futuristic digital laboratory with glowing holographic neural network data streams and researchers collaborating.",
            localDrawableRes = R.drawable.hero_story_banner_1787934764195,
            rawStoryText = """As algorithmic models become increasingly [L:ubiquitous](Present or found everywhere - C1) across society, computer scientists must scrutinize their societal impact. Dr. Aris [T:had anticipated](Past Perfect - Action completed prior to another past event) these ethical dilemmas long before automated frameworks dominated healthcare systems. [C:Notwithstanding](In spite of / Despite - C1) initial resistance from industry executives, his pioneering research forced policymakers to institute rigorous safeguards. [C:Whereas](Introduces a direct comparison or contrast) past technological shifts primarily impacted manual labor, cognitive automation directly alters creative industries. Consequently, engineers [T:are striving](Present Continuous - Action in progress now) to design transparent algorithms [C:lest](To prevent the risk that / for fear that - C1) biased data corrupt democratic decision-making.""",
            quizQuestions = listOf(QuizQuestion(
                question = "What does the word 'ubiquitous' mean in this context?",
                options = listOf("A) Rare and difficult to locate", "B) Present or found everywhere", "C) Highly dangerous and unstable"),
                correctAnswerIndex = 1,
                explanation = "'Ubiquitous' describes something that appears everywhere in daily life."
            ), QuizQuestion(
                question = "Why is 'had anticipated' conjugated in the Past Perfect tense?",
                options = listOf("A) To show a routine daily action", "B) To describe an action completed before another event in the past", "C) To predict a future event"),
                correctAnswerIndex = 1,
                explanation = "Past Perfect ('had anticipated') indicates Dr. Aris foresaw the issues before the automated frameworks dominated."
            ), QuizQuestion(
                question = "What is the role of the conjunction 'lest' in the passage?",
                options = listOf("A) To express a purpose of avoiding a potential negative outcome", "B) To summarize main arguments", "C) To request user feedback"),
                correctAnswerIndex = 0,
                explanation = "'lest' means 'to prevent the risk that' or 'for fear that'."
            ))
        ),

        StoryData(
            id = "daily_a2_1",
            title = "A Quiet Sunday Afternoon",
            level = CefrLevel.A2,
            theme = StoryTheme.DAILY_LIFE,
            imagePrompt = "A sunlight-filled living room with indoor plants, a cat sleeping on a rug, and a warm cup of coffee on a wooden table.",
            localDrawableRes = R.drawable.hero_story_banner_1787934764195,
            rawStoryText = """Emma [T:enjoys](Present Simple - Habitual preference) spending her Sundays at home [C:because](Shows reason) the weekday commute is exhausting. She [T:is brewing](Present Continuous - Action happening right now) fresh lavender tea [C:while](Shows simultaneous timeline) her cat sleeps peacefully on the armchair. [C:Although](Shows contrast) rain is falling outside, her apartment feels cozy and warm. She reads a chapter of her favorite book [C:before](Indicates preceding time) preparing a delicious soup for dinner. This quiet routine helps her stay [L:refreshed](Restored in energy and vitality - A2) for the upcoming week.""",
            quizQuestions = listOf(QuizQuestion(
                question = "What is Emma doing while her cat sleeps?",
                options = listOf("A) She is driving to work", "B) She is brewing fresh lavender tea", "C) She is shopping at a market"),
                correctAnswerIndex = 1,
                explanation = "The story notes: 'She is brewing fresh lavender tea while her cat sleeps'."
            ), QuizQuestion(
                question = "What does 'refreshed' mean in CEFR A2 vocabulary?",
                options = listOf("A) Feeling tired and stressed", "B) Restored in energy and vitality", "C) Angry about bad weather"),
                correctAnswerIndex = 1,
                explanation = "'Refreshed' means feeling energized and renewed."
            ), QuizQuestion(
                question = "Which tense is used in 'She is brewing'?",
                options = listOf("A) Present Continuous", "B) Future Simple", "C) Past Simple"),
                correctAnswerIndex = 0,
                explanation = "'is brewing' is in the Present Continuous tense (be + verb-ing)."
            ))
        )
    )
}
