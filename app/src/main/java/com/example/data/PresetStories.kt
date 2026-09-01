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
        rawStoryText = """[N:Tom](Subject Noun - Main traveler) [T:wakes up](Present Simple - Routine & habit) [ADV:early](Adverb of Time - Modifies 'wakes up') today [C:because](Subordinating Conjunction - Explains cause) it is his [ADJ:first](Ordinal Adjective - Modifies 'day') day in [N:London](Proper Noun - Destination city). He [T:feels](Present Simple - Stative verb of emotion) a bit [L:nervous](Anxious or worried - A2) about navigating the underground, [C:but](Coordinating Conjunction - Shows contrast) his [N:enthusiasm](Abstract Noun - Key motivation) keeps him going. After a [L:hearty](Substantial and satisfying - A2) [N:breakfast](Concrete Noun - Morning meal) at a [ADJ:cozy](Descriptive Adjective - Warm & comfortable) local cafe, he decides to visit Big Ben. [S:Relative Clause:While he is waiting for the bus](Dependent temporal clause describing simultaneous actions), an [ADJ:elderly](Descriptive Adjective - Modifies 'lady') lady [ADV:kindly](Adverb of Manner - Modifies 'offers') offers directions. She [T:explains](Present Simple - General truth) the city route with great detail. Tom thanks her [ADV:warmly](Adverb of Manner - Expressing gratitude) [C:and](Coordinating Conjunction - Connects actions) walks [P:towards](Preposition of Direction - Indicates movement to destination) the station. He feels [L:confident](Feeling sure of oneself - A2) that this trip will be unforgettable.""",
        quizQuestions = listOf(QuizQuestion(
            question = "Why does Tom wake up early?",
            options = listOf("A) Because he has a flight to catch", "B) Because it is his first day in London", "C) Because his alarm rings continuously"),
            correctAnswerIndex = 1,
            explanation = "The text states: 'Tom wakes up early today because it is his first day in London.'"
        ), QuizQuestion(
            question = "What part of speech is 'warmly' in 'Tom thanks her warmly'?",
            options = listOf("A) Adverb of Manner", "B) Proper Noun", "C) Conjunction"),
            correctAnswerIndex = 0,
            explanation = "'warmly' is an Adverb of Manner describing how Tom thanks the lady."
        ), QuizQuestion(
            question = "What sentence structure is 'While he is waiting for the bus'?",
            options = listOf("A) Independent clause", "B) Dependent temporal clause / Relative Clause", "C) Passive voice construction"),
            correctAnswerIndex = 1,
            explanation = "'While he is waiting for the bus' is a dependent temporal clause showing simultaneous action."
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
            rawStoryText = """[N:Sarah](Subject Noun - Lead presenter) [T:has been rehearsing](Present Perfect Continuous - Action started in past and ongoing) her slides all night [C:so that](Subordinating Conjunction - Expresses purpose) she can deliver a [ADJ:flawless](Descriptive Adjective - Perfect & without defect) pitch [P:to](Preposition of Direction - Recipient of pitch) the executive board. Although she felt slightly [L:overwhelmed](Feeling burdened by intense responsibility - B1) by the [ADJ:strict](Descriptive Adjective - Stringent & demanding) deadline, her [N:team](Collective Noun - Project colleagues) provided invaluable research. [S:Conditional Clause:In order to engage her audience](Infinitive subordinate purpose structure), she begins her presentation with a [ADJ:compelling](Descriptive Adjective - Fascinating & persuasive) case study. The board members [T:nodded](Past Simple - Completed past reaction) [ADV:attentively](Adverb of Manner - Listening with close attention) throughout her talk. [C:Furthermore](Transitional Connector - Adds supporting information), the chief executive asked several [ADJ:thoughtful](Descriptive Adjective - Reflective & deep) questions. Sarah answered each inquiry with [L:poise](Calm dignity and self-assurance - B1) and conviction, [S:Participial Clause:securing the contract successfully](Participial clause describing resulting success).""",
            quizQuestions = listOf(QuizQuestion(
                question = "Why did Sarah rehearse her slides all night?",
                options = listOf("A) To study for a university exam", "B) So that she could deliver a flawless pitch", "C) To finish writing a novel"),
                correctAnswerIndex = 1,
                explanation = "The text states 'Sarah has been rehearsing her slides all night so that she can deliver a flawless pitch'."
            ), QuizQuestion(
                question = "What does the target vocabulary 'poise' mean?",
                options = listOf("A) Sudden anger and panic", "B) Calm dignity and self-assurance", "C) Hesitation and uncertainty"),
                correctAnswerIndex = 1,
                explanation = "'Poise' refers to maintaining calm dignity and composure."
            ), QuizQuestion(
                question = "What verb tense is 'has been rehearsing'?",
                options = listOf("A) Present Perfect Continuous", "B) Past Simple", "C) Future Perfect"),
                correctAnswerIndex = 0,
                explanation = "'has been rehearsing' is Present Perfect Continuous, expressing an activity spanning from past to present."
            ))
        ),

        StoryData(
            id = "tech_c1_1",
            title = "Ethics in the Age of Synthetic Intelligence",
            level = CefrLevel.C1,
            theme = StoryTheme.TECHNOLOGY,
            imagePrompt = "Futuristic digital laboratory with glowing holographic neural network data streams and researchers collaborating.",
            localDrawableRes = R.drawable.hero_story_banner_1787934764195,
            rawStoryText = """As algorithmic models become increasingly [L:ubiquitous](Present or found everywhere - C1) across society, [N:scientists](Subject Noun - Researchers) must scrutinize their [ADJ:societal](Classifying Adjective - Relating to society) impact. [N:Dr. Aris](Proper Noun - Lead researcher) [T:had anticipated](Past Perfect - Action completed prior to another past milestone) these [ADJ:ethical](Descriptive Adjective - Moral principles) dilemmas [P:before](Preposition of Time - Preceding event) automated frameworks dominated healthcare. [C:Notwithstanding](Prepositional Connector - In spite of / Despite - C1) [ADJ:initial](Descriptive Adjective - Early stage) resistance from industry executives, his [ADJ:pioneering](Descriptive Adjective - Groundbreaking & novel) research forced policymakers to institute [ADJ:rigorous](Descriptive Adjective - Strict & meticulous) safeguards. [C:Whereas](Subordinating Conjunction - Introduces direct contrast) past shifts primarily impacted manual labor, cognitive automation [ADV:directly](Adverb of Degree/Manner - Modifies 'alters') alters creative industries. Consequently, engineers [T:are striving](Present Continuous - Active ongoing endeavor) to design [ADJ:transparent](Descriptive Adjective - Clear and understandable) systems [C:lest](Conjunction - For fear that / To prevent risk - C1) biased data corrupt democratic decision-making.""",
            quizQuestions = listOf(QuizQuestion(
                question = "What does the word 'ubiquitous' mean in this context?",
                options = listOf("A) Rare and difficult to locate", "B) Present or found everywhere", "C) Highly dangerous and unstable"),
                correctAnswerIndex = 1,
                explanation = "'Ubiquitous' describes something that appears everywhere in daily life."
            ), QuizQuestion(
                question = "Why is 'had anticipated' conjugated in the Past Perfect tense?",
                options = listOf("A) To show a routine daily action", "B) To describe an action completed before another past event", "C) To predict a future event"),
                correctAnswerIndex = 1,
                explanation = "Past Perfect ('had anticipated') indicates Dr. Aris foresaw the issues before automated frameworks dominated."
            ), QuizQuestion(
                question = "What is the role of the conjunction 'lest' in the passage?",
                options = listOf("A) To express prevention of a potential negative outcome", "B) To summarize main arguments", "C) To request user feedback"),
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
            rawStoryText = """[N:Emma](Subject Noun - Main protagonist) [T:enjoys](Present Simple - Habitual preference) spending her Sundays [P:at](Preposition of Place - Location) home [C:because](Subordinating Conjunction - Explains reason) the weekday commute is [ADJ:exhausting](Descriptive Adjective - Tiring & draining). She [T:is brewing](Present Continuous - Action happening right now) [ADJ:fresh](Descriptive Adjective - Newly prepared) lavender tea [S:Temporal Clause:while her cat sleeps peacefully](Subordinate temporal clause describing background action). [C:Although](Subordinating Conjunction - Expresses concession/contrast) rain is falling outside, her apartment feels [ADJ:cozy](Descriptive Adjective - Comfortable & warm). She reads a chapter [P:of](Preposition of Possession/Specification) her favorite book [C:before](Prepositional Conjunction - Preceding event) preparing a [ADJ:delicious](Descriptive Adjective - Highly tasty) soup for dinner. This [ADJ:quiet](Descriptive Adjective - Peaceful & calm) routine helps her stay [L:refreshed](Restored in energy and vitality - A2) for the upcoming week.""",
            quizQuestions = listOf(QuizQuestion(
                question = "What is Emma doing while her cat sleeps?",
                options = listOf("A) She is driving to work", "B) She is brewing fresh lavender tea", "C) She is shopping at a market"),
                correctAnswerIndex = 1,
                explanation = "The story notes: 'She is brewing fresh lavender tea while her cat sleeps'."
            ), QuizQuestion(
                question = "What part of speech is 'fresh' in 'fresh lavender tea'?",
                options = listOf("A) Descriptive Adjective", "B) Verb Tense", "C) Preposition"),
                correctAnswerIndex = 0,
                explanation = "'fresh' is a descriptive adjective modifying the noun 'lavender tea'."
            ), QuizQuestion(
                question = "Which tense is used in 'She is brewing'?",
                options = listOf("A) Present Continuous", "B) Future Simple", "C) Past Simple"),
                correctAnswerIndex = 0,
                explanation = "'is brewing' is in the Present Continuous tense (be + verb-ing)."
            ))
        )
    )
}

