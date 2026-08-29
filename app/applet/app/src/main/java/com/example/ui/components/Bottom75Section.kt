package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ParsedPart
import com.example.data.QuizQuestion
import com.example.data.StoryData
import com.example.ui.theme.BorderLightPolish
import com.example.ui.theme.BorderPolish
import com.example.ui.theme.ConjunctionBg
import com.example.ui.theme.ConjunctionBorder
import com.example.ui.theme.ConjunctionText
import com.example.ui.theme.LexiconBg
import com.example.ui.theme.LexiconBorder
import com.example.ui.theme.LexiconText
import com.example.ui.theme.PrimaryContainerPurple
import com.example.ui.theme.PrimaryPurple
import com.example.ui.theme.SecondaryViolet
import com.example.ui.theme.SurfaceVariantPolish
import com.example.ui.theme.TenseBg
import com.example.ui.theme.TenseBorder
import com.example.ui.theme.TenseText
import com.example.ui.theme.TextPrimaryDark
import com.example.ui.theme.TextSecondaryMedium

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Bottom75Section(
    story: StoryData,
    parsedParts: List<ParsedPart>,
    onAnnotationClick: (ParsedPart) -> Unit,
    isPlayingAudio: Boolean,
    currentSentenceIndex: Int,
    onToggleAudio: () -> Unit,
    onStopAudio: () -> Unit,
    speechRate: Float,
    onChangeSpeechRate: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    // Quiz State
    val userAnswers = remember(story.id) { mutableStateMapOf<Int, Int>() }
    var quizSubmitted by remember(story.id) { mutableStateOf(false) }

    // Always highlight toggle vs Reach/Audio Sync mode
    var alwaysHighlightAll by remember { mutableStateOf(false) }
    val userTappedIndices = remember(story.id) { mutableStateMapOf<Int, Boolean>() }

    // Map each parsed part to its sentence index
    val partSentenceIndices = remember(parsedParts) {
        var sentenceCounter = 0
        parsedParts.map { part ->
            val sentenceIdx = sentenceCounter
            val text = when (part) {
                is ParsedPart.NormalText -> part.text
                is ParsedPart.Lexicon -> part.word
                is ParsedPart.VerbTense -> part.word
                is ParsedPart.Conjunction -> part.word
            }
            if (text.contains('.') || text.contains('!') || text.contains('?')) {
                sentenceCounter += text.count { it == '.' || it == '!' || it == '?' }
            }
            sentenceIdx
        }
    }

    // Animation for the reading pointer (Hand)
    val infiniteTransition = rememberInfiniteTransition(label = "reading_pointer")
    val pointerOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 6f,
        animationSpec = infiniteRepeatable(
            animation = tween(400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pointer_offset_anim"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. AUDIO PLAYER FLOATING TOOLBAR ---
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderLightPolish),
            shadowElevation = 3.dp,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("audio_toolbar")
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(
                        onClick = onToggleAudio,
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(PrimaryPurple)
                            .testTag("play_pause_audio_button")
                    ) {
                        Icon(
                            imageVector = if (isPlayingAudio) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isPlayingAudio) "Pause Audio" else "Play Audio",
                            tint = Color.White
                        )
                    }

                    if (isPlayingAudio) {
                        IconButton(
                            onClick = onStopAudio,
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.errorContainer)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "Stop Audio",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Headphones,
                                contentDescription = "Audio Icon",
                                tint = PrimaryPurple,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isPlayingAudio) "Reading Sentence ${currentSentenceIndex + 1}..." else "Audio Companion",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = TextPrimaryDark
                                )
                            )
                        }
                        Text(
                            text = if (isPlayingAudio) "Highlights reach words as audio plays" else "Tap words or listen to reach highlights",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = TextSecondaryMedium,
                                fontSize = 11.sp
                            )
                        )
                    }
                }

                // Speed Selector Pills
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    listOf(0.5f, 1.0f, 1.5f, 2.0f).forEach { rate ->
                        val isSelected = speechRate == rate
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) PrimaryPurple else SurfaceVariantPolish
                                )
                                .clickable { onChangeSpeechRate(rate) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = if (rate % 1.0f == 0.0f) "${rate.toInt()}x" else "${rate}x",
                                color = if (isSelected) Color.White else TextSecondaryMedium,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }
                }
            }
        }

        // --- 2. INTERACTIVE READING CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("story_reader_card"),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderPolish),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(width = 24.dp, height = 4.dp)
                                .clip(CircleShape)
                                .background(PrimaryPurple)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "INTERACTIVE READING",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = PrimaryPurple,
                                letterSpacing = 1.sp,
                                fontSize = 11.sp
                            )
                        )
                    }

                    // Mode Toggle: Highlight as reached vs Always show
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = if (alwaysHighlightAll) "All Tags" else "Reach Sync",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 10.sp,
                                color = TextSecondaryMedium,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Switch(
                            checked = alwaysHighlightAll,
                            onCheckedChange = { alwaysHighlightAll = it },
                            modifier = Modifier.size(scale = 0.75f, density = androidx.compose.ui.platform.LocalDensity.current.density),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryPurple
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    parsedParts.forEachIndexed { index, part ->
                        val sentenceIdx = partSentenceIndices.getOrElse(index) { 0 }
                        
                        // HIGHLY PRECISE HIGHLIGHT LOGIC:
                        // 1. Is audio actively playing and exactly on this sentence? (Sync as we reach it)
                        val isCurrentlyReading = isPlayingAudio && currentSentenceIndex == sentenceIdx
                        // 2. Did the user manually tap it?
                        val isTappedByUser = userTappedIndices[index] == true
                        // 3. Or did they flip the global "Highlight All" switch?
                        val isHighlighted = alwaysHighlightAll || isCurrentlyReading || isTappedByUser

                        // Reading Pointer (Hand Icon) pointing to the current sentence being read
                        val isFirstPartInSentence = index == 0 || partSentenceIndices.getOrElse(index - 1) { -1 } != sentenceIdx
                        if (isCurrentlyReading && isFirstPartInSentence) {
                            Box(
                                modifier = Modifier
                                    .padding(end = 4.dp)
                                    .offset(x = pointerOffset.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "👉",
                                    fontSize = 18.sp
                                )
                            }
                        }

                        when (part) {
                            is ParsedPart.NormalText -> {
                                val textBgColor by animateColorAsState(
                                    if (isPlayingAudio && sentenceIdx == currentSentenceIndex) PrimaryContainerPurple.copy(alpha = 0.35f) else Color.Transparent,
                                    label = "sentence_highlight"
                                )
                                Surface(
                                    color = textBgColor,
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        text = part.text,
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontSize = 15.sp,
                                            lineHeight = 26.sp,
                                            color = TextSecondaryMedium
                                        )
                                    )
                                }
                            }
                            is ParsedPart.Lexicon -> {
                                AnnotationPillChip(
                                    text = part.word,
                                    badgeLabel = "L: ${part.level}",
                                    isHighlighted = isHighlighted,
                                    bgColor = LexiconBg,
                                    textColor = LexiconText,
                                    borderColor = LexiconBorder,
                                    onClick = {
                                        userTappedIndices[index] = true
                                        onAnnotationClick(part)
                                    }
                                )
                            }
                            is ParsedPart.VerbTense -> {
                                AnnotationPillChip(
                                    text = part.word,
                                    badgeLabel = "Tense",
                                    isHighlighted = isHighlighted,
                                    bgColor = TenseBg,
                                    textColor = TenseText,
                                    borderColor = TenseBorder,
                                    onClick = {
                                        userTappedIndices[index] = true
                                        onAnnotationClick(part)
                                    }
                                )
                            }
                            is ParsedPart.Conjunction -> {
                                AnnotationPillChip(
                                    text = part.word,
                                    badgeLabel = "Conj",
                                    isHighlighted = isHighlighted,
                                    bgColor = ConjunctionBg,
                                    textColor = ConjunctionText,
                                    borderColor = ConjunctionBorder,
                                    onClick = {
                                        userTappedIndices[index] = true
                                        onAnnotationClick(part)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        // --- 3. COMPREHENSION CHECK CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("quiz_section_card"),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceVariantPolish),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderLightPolish),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = PrimaryPurple,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "?",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "COMPREHENSION CHECK",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                letterSpacing = 1.sp,
                                color = TextPrimaryDark
                            )
                        )
                    }

                    if (quizSubmitted) {
                        val score = story.quizQuestions.indices.count { idx ->
                            userAnswers[idx] == story.quizQuestions[idx].correctAnswerIndex
                        }
                        Surface(
                            shape = CircleShape,
                            color = if (score == story.quizQuestions.size) Color(0xFF10B981) else PrimaryPurple
                        ) {
                            Text(
                                text = "$score/${story.quizQuestions.size} Correct",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                story.quizQuestions.forEachIndexed { qIndex, question ->
                    QuizQuestionPolishCard(
                        index = qIndex + 1,
                        question = question,
                        selectedOption = userAnswers[qIndex],
                        onSelectOption = { optionIdx ->
                            if (!quizSubmitted) {
                                userAnswers[qIndex] = optionIdx
                            }
                        },
                        isSubmitted = quizSubmitted
                    )
                }

                // Submit / Retry Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (quizSubmitted) {
                        Button(
                            onClick = {
                                userAnswers.clear()
                                quizSubmitted = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SecondaryViolet),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Icon(imageVector = Icons.Default.RestartAlt, contentDescription = "Retry", tint = Color(0xFF381E72))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Retry Quiz", color = Color(0xFF381E72))
                        }
                    } else {
                        Button(
                            onClick = { quizSubmitted = true },
                            enabled = userAnswers.size == story.quizQuestions.size,
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.testTag("submit_quiz_button")
                        ) {
                            Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Check Answers")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))
    }
}

@Composable
private fun AnnotationPillChip(
    text: String,
    badgeLabel: String,
    isHighlighted: Boolean,
    bgColor: Color,
    textColor: Color,
    borderColor: Color,
    onClick: () -> Unit
) {
    val animatedBg by animateColorAsState(
        if (isHighlighted) bgColor else Color.Transparent,
        label = "chip_bg"
    )
    val animatedText by animateColorAsState(
        if (isHighlighted) textColor else TextSecondaryMedium,
        label = "chip_text"
    )

    Surface(
        modifier = Modifier
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        color = animatedBg,
        border = if (isHighlighted) androidx.compose.foundation.BorderStroke(1.dp, borderColor) else null
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = if (isHighlighted) 8.dp else 0.dp,
                vertical = if (isHighlighted) 3.dp else 0.dp
            )
        ) {
            Text(
                text = text,
                color = animatedText,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 15.sp,
                    lineHeight = 26.sp
                )
            )
            if (isHighlighted) {
                Spacer(modifier = Modifier.width(4.dp))
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = animatedText.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = badgeLabel,
                        color = animatedText,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun QuizQuestionPolishCard(
    index: Int,
    question: QuizQuestion,
    selectedOption: Int?,
    onSelectOption: (Int) -> Unit,
    isSubmitted: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "$index. ${question.question}",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = TextPrimaryDark
            )
        )

        question.options.forEachIndexed { optIndex, optionText ->
            val isSelected = selectedOption == optIndex
            val isCorrect = optIndex == question.correctAnswerIndex

            val optionBgColor = when {
                isSubmitted && isCorrect -> Color(0xFFD1FAE5)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFFEE2E2)
                isSelected -> PrimaryContainerPurple
                else -> Color.White
            }

            val optionBorderColor = when {
                isSubmitted && isCorrect -> Color(0xFF10B981)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                isSelected -> PrimaryPurple
                else -> BorderPolish
            }

            val circleBgColor = when {
                isSelected -> PrimaryPurple
                else -> Color.Transparent
            }

            val circleTextColor = when {
                isSelected -> Color.White
                else -> TextPrimaryDark
            }

            val optionLetter = when(optIndex) {
                0 -> "A"
                1 -> "B"
                else -> "C"
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .clickable { onSelectOption(optIndex) },
                color = optionBgColor,
                border = androidx.compose.foundation.BorderStroke(1.dp, optionBorderColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .clip(CircleShape)
                            .background(circleBgColor)
                            .border(1.dp, if (isSelected) PrimaryPurple else BorderPolish, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = optionLetter,
                            color = circleTextColor,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = optionText.replace(Regex("""^[A-C]\)\s*"""), ""),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 13.sp,
                            color = TextPrimaryDark
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    if (isSubmitted && isCorrect) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Correct",
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(18.dp)
                        )
                    } else if (isSubmitted && isSelected && !isCorrect) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Incorrect",
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        if (isSubmitted) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color.White,
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderLightPolish),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "💡 Explanation: ${question.explanation}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = TextSecondaryMedium,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}
