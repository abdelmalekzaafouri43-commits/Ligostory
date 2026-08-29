package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.togetherWith
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import com.example.api.DictionaryApi
import com.example.api.WordDefinition
import androidx.compose.material3.CircularProgressIndicator
import com.example.tts.EnglishAccent
import com.example.data.ParsedPart
import com.example.data.QuizQuestion
import com.example.data.StoryData
import com.example.parser.StoryMarkupParser
import com.example.ui.theme.ConjunctionBg
import com.example.ui.theme.ConjunctionBorder
import com.example.ui.theme.ConjunctionText
import com.example.ui.theme.LexiconBg
import com.example.ui.theme.LexiconBorder
import com.example.ui.theme.LexiconText
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.SecondaryTeal
import com.example.ui.theme.TenseBg
import com.example.ui.theme.TenseBorder
import com.example.ui.theme.TenseText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Bottom75Section(
    story: StoryData,
    parsedParts: List<ParsedPart>,
    onAnnotationClick: (ParsedPart) -> Unit,
    isPlayingAudio: Boolean,
    currentWordRange: IntRange?,
    onToggleAudio: () -> Unit,
    onStopAudio: () -> Unit,
    speechRate: Float,
    onChangeSpeechRate: (Float) -> Unit,
    currentAccent: EnglishAccent = EnglishAccent.US_NATIVE,
    onChangeAccent: (EnglishAccent) -> Unit = {},
    modifier: Modifier = Modifier,
    scrollState: androidx.compose.foundation.ScrollState = rememberScrollState()
) {

    // Quiz State
    val userAnswers = remember(story.id) { mutableStateMapOf<Int, Int>() }
    var quizSubmitted by remember(story.id) { mutableStateOf(false) }
    
    val coroutineScope = rememberCoroutineScope()
    var popupWordDef by remember { mutableStateOf<WordDefinition?>(null) }
    var isFetchingDefinition by remember { mutableStateOf(false) }

    // Map each parsed part to its start and end character index in the plain text
    val partCharRanges = remember(parsedParts) {
        val ranges = mutableListOf<IntRange>()
        var currentIndex = 0
        parsedParts.forEach { part ->
            val text = when (part) {
                is ParsedPart.NormalText -> part.text
                is ParsedPart.Lexicon -> part.word
                is ParsedPart.VerbTense -> part.word
                is ParsedPart.Conjunction -> part.word
            }
            val start = currentIndex
            val end = currentIndex + text.length
            ranges.add(start until end)
            currentIndex = end
        }
        ranges
    }

    // Page model representing a parsed part and its original global index
    class PagePart(val part: ParsedPart, val globalIndex: Int)

    // Current Active Page index
    var currentPageIndex by remember(story.id) { mutableIntStateOf(0) }

    // Dynamically split story parts into 2 or 3 pages
    val storyPages = remember(story.id, parsedParts) {
        if (parsedParts.isEmpty()) {
            listOf(emptyList<PagePart>())
        } else {
            val pageParts = parsedParts.mapIndexed { index, part -> PagePart(part, index) }
            
            // Find sentence boundaries to split on
            val sentenceEndIndices = mutableListOf<Int>()
            pageParts.forEachIndexed { index, pagePart ->
                val text = when (pagePart.part) {
                    is ParsedPart.NormalText -> pagePart.part.text
                    is ParsedPart.Lexicon -> pagePart.part.word
                    is ParsedPart.VerbTense -> pagePart.part.word
                    is ParsedPart.Conjunction -> pagePart.part.word
                }
                val trimmed = text.trim()
                if (trimmed.endsWith(".") || trimmed.endsWith("!") || trimmed.endsWith("?") || trimmed.endsWith(".\"") || trimmed.endsWith("!\"") || trimmed.endsWith("?\"")) {
                    sentenceEndIndices.add(index)
                }
            }

            val numPages = if (parsedParts.size > 15) 3 else 2

            if (sentenceEndIndices.size < numPages) {
                val chunkSize = (pageParts.size + numPages - 1) / numPages
                pageParts.chunked(chunkSize)
            } else {
                val pages = mutableListOf<List<PagePart>>()
                var lastCutIndex = -1
                for (i in 1..numPages) {
                    if (i == numPages) {
                        pages.add(pageParts.subList(lastCutIndex + 1, pageParts.size))
                    } else {
                        val targetSentenceIndex = (sentenceEndIndices.size * i / numPages) - 1
                        val cutIndex = sentenceEndIndices.getOrElse(targetSentenceIndex) { pageParts.size * i / numPages }
                        pages.add(pageParts.subList(lastCutIndex + 1, cutIndex + 1))
                        lastCutIndex = cutIndex
                    }
                }
                pages
            }
        }
    }

    // Auto-paging effect: turns page automatically as TTS audio reads
    androidx.compose.runtime.LaunchedEffect(currentWordRange, isPlayingAudio) {
        if (isPlayingAudio && currentWordRange != null) {
            val activeGlobalIndex = partCharRanges.indexOfFirst { range ->
                currentWordRange.first in range
            }
            if (activeGlobalIndex != -1) {
                val targetPageIndex = storyPages.indexOfFirst { page ->
                    page.any { it.globalIndex == activeGlobalIndex }
                }
                if (targetPageIndex != -1 && targetPageIndex != currentPageIndex) {
                    currentPageIndex = targetPageIndex
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. AUDIO LISTENING TOOLBAR ---
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(16.dp)
                )
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
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                        onClick = onToggleAudio,
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(PrimaryIndigo)
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
                        Text(
                            text = if (isPlayingAudio) "🔊 Native Audio Playing" else "🎧 Native Voice Audio",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        )
                        Text(
                            text = "Tap words for grammar & vocabulary tips",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                fontSize = 11.sp
                            )
                        )
                    }
                }

                // Accent & Speed Controls
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Accent Selector
                    EnglishAccent.entries.forEach { accent ->
                        val isSelected = currentAccent == accent
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isSelected) SecondaryTeal else MaterialTheme.colorScheme.surfaceVariant
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) Color.Transparent else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onChangeAccent(accent) }
                                .padding(horizontal = 7.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = if (accent == EnglishAccent.US_NATIVE) "🇺🇸 US" else "🇬🇧 UK",
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }

                    // Speed Selector Pills
                    listOf(0.8f, 1.0f, 1.2f).forEach { rate ->
                        val isSelected = speechRate == rate
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isSelected) PrimaryIndigo else MaterialTheme.colorScheme.surfaceVariant
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) Color.Transparent else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onChangeSpeechRate(rate) }
                                .padding(horizontal = 6.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "${rate}x",
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                )
                            )
                        }
                    }
                }
            }
        }

        // --- 2. MARKUP LEGEND BAR ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LegendPill(label = "Vocabulary", bgColor = LexiconBg, textColor = LexiconText, borderColor = LexiconBorder)
            LegendPill(label = "Verb Tense", bgColor = TenseBg, textColor = TenseText, borderColor = TenseBorder)
            LegendPill(label = "Conjunction", bgColor = ConjunctionBg, textColor = ConjunctionText, borderColor = ConjunctionBorder)
        }

        // --- 3. INTERACTIVE STORY READER CONTAINER ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(20.dp)
                )
                .testTag("story_reader_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "📖 Story Text",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                AnimatedContent(
                    targetState = currentPageIndex,
                    transitionSpec = {
                        if (targetState > initialState) {
                            (slideInHorizontally { width -> width } + fadeIn())
                                .togetherWith(slideOutHorizontally { width -> -width } + fadeOut())
                        } else {
                            (slideInHorizontally { width -> -width } + fadeIn())
                                .togetherWith(slideOutHorizontally { width -> width } + fadeOut())
                        }
                    },
                    label = "story_page_animation"
                ) { pageIdx ->
                    val activePageParts = storyPages.getOrElse(pageIdx) { emptyList() }
                    
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        activePageParts.forEach { pagePart ->
                            val index = pagePart.globalIndex
                            val part = pagePart.part
                            val charRange = partCharRanges.getOrNull(index) ?: IntRange.EMPTY
                            val isWordBeingRead = isPlayingAudio && currentWordRange != null && currentWordRange.first in charRange

                            if (isWordBeingRead) {
                                Text(
                                    text = "🪶",
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(end = 2.dp)
                                )
                            }
                            when (part) {
                                is ParsedPart.NormalText -> {
                                    val textBgColor by animateColorAsState(
                                        if (isWordBeingRead) PrimaryIndigo.copy(alpha = 0.5f) else Color.Transparent,
                                        label = "word_highlight"
                                    )
                                    var textLayoutResult by remember { mutableStateOf<androidx.compose.ui.text.TextLayoutResult?>(null) }
                                    Surface(
                                        color = textBgColor,
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = part.text,
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontSize = 16.sp,
                                                lineHeight = 26.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            ),
                                            onTextLayout = { textLayoutResult = it },
                                            modifier = Modifier.pointerInput(Unit) {
                                                detectTapGestures(
                                                    onTap = { pos ->
                                                        textLayoutResult?.let { layoutResult ->
                                                            val offset = layoutResult.getOffsetForPosition(pos)
                                                            val textStr = part.text
                                                            if (offset in textStr.indices) {
                                                                var start = offset
                                                                while (start > 0 && textStr[start - 1].isLetterOrDigit()) { start-- }
                                                                var end = offset
                                                                while (end < textStr.length && textStr[end].isLetterOrDigit()) { end++ }
                                                                if (start < end) {
                                                                    val clickedWord = textStr.substring(start, end)
                                                                    coroutineScope.launch {
                                                                        isFetchingDefinition = true
                                                                        popupWordDef = DictionaryApi.fetchDefinition(clickedWord)
                                                                        if (popupWordDef == null) {
                                                                            popupWordDef = WordDefinition(clickedWord, "", "unknown", "Definition not found.", "")
                                                                        }
                                                                        isFetchingDefinition = false
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    },
                                                    onLongPress = { pos ->
                                                        textLayoutResult?.let { layoutResult ->
                                                            val offset = layoutResult.getOffsetForPosition(pos)
                                                            val textStr = part.text
                                                            if (offset in textStr.indices) {
                                                                var start = offset
                                                                while (start > 0 && textStr[start - 1].isLetterOrDigit()) { start-- }
                                                                var end = offset
                                                                while (end < textStr.length && textStr[end].isLetterOrDigit()) { end++ }
                                                                if (start < end) {
                                                                    val clickedWord = textStr.substring(start, end)
                                                                    coroutineScope.launch {
                                                                        isFetchingDefinition = true
                                                                        popupWordDef = DictionaryApi.fetchDefinition(clickedWord)
                                                                        if (popupWordDef == null) {
                                                                            popupWordDef = WordDefinition(clickedWord, "", "unknown", "Definition not found.", "")
                                                                        }
                                                                        isFetchingDefinition = false
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                )
                                            }
                                        )
                                    }
                                }
                                is ParsedPart.Lexicon -> {
                                    AnnotationChip(
                                        text = part.word,
                                        badgeLabel = part.level,
                                        bgColor = LexiconBg,
                                        textColor = LexiconText,
                                        borderColor = if (isWordBeingRead) PrimaryIndigo else LexiconBorder,
                                        onClick = { onAnnotationClick(part) }
                                    )
                                }
                                is ParsedPart.VerbTense -> {
                                    AnnotationChip(
                                        text = part.word,
                                        badgeLabel = "Tense",
                                        bgColor = TenseBg,
                                        textColor = TenseText,
                                        borderColor = if (isWordBeingRead) PrimaryIndigo else TenseBorder,
                                        onClick = { onAnnotationClick(part) }
                                    )
                                }
                                is ParsedPart.Conjunction -> {
                                    AnnotationChip(
                                        text = part.word,
                                        badgeLabel = "Conj",
                                        bgColor = ConjunctionBg,
                                        textColor = ConjunctionText,
                                        borderColor = if (isWordBeingRead) PrimaryIndigo else ConjunctionBorder,
                                        onClick = { onAnnotationClick(part) }
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (currentPageIndex > 0) {
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { currentPageIndex-- }
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 14.dp, vertical = 6.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = "Previous Page",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.width(1.dp))
                    }

                    Text(
                        text = "Page ${currentPageIndex + 1} of ${storyPages.size}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                        )
                    )

                    if (currentPageIndex < storyPages.size - 1) {
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { currentPageIndex++ }
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 14.dp, vertical = 6.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = "Next Page",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.width(1.dp))
                    }
                }
            }
        }

        // --- 4. COMPREHENSION & GRAMMAR QUIZ SECTION (COLLAPSED BY DEFAULT) ---
        var isQuizExpanded by remember(story.id) { mutableStateOf(false) }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable { isQuizExpanded = !isQuizExpanded }
                .testTag("quiz_section_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isQuizExpanded) "Quiz & Practice (Tap to Collapse)" else "Story Comprehension & Quiz (Tap to Expand)",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = if (isQuizExpanded) MaterialTheme.colorScheme.onSurface else PrimaryIndigo
                        )
                    )

                    if (quizSubmitted) {
                        val score = story.quizQuestions.indices.count { idx ->
                            userAnswers[idx] == story.quizQuestions[idx].correctAnswerIndex
                        }
                        Surface(
                            shape = CircleShape,
                            color = if (score == story.quizQuestions.size) Color(0xFF10B981) else Color(0xFF3B82F6)
                        ) {
                            Text(
                                text = "Score: $score/${story.quizQuestions.size}",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                            )
                        }
                    } else {
                        Text(
                            text = if (isQuizExpanded) "Active" else "Tap to Open",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = if (isQuizExpanded) PrimaryIndigo else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                            )
                        )
                    }
                }

                AnimatedVisibility(visible = isQuizExpanded) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Divider()

                        story.quizQuestions.forEachIndexed { qIndex, question ->
                            QuizQuestionCard(
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

                        // Submit / Reset Quiz Button
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
                                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text("Retry Quiz")
                                }
                            } else {
                                Button(
                                    onClick = { quizSubmitted = true },
                                    enabled = userAnswers.size == story.quizQuestions.size,
                                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.testTag("submit_quiz_button")
                                ) {
                                    Text("Check Answers")
                                }
                            }
                        }
                    }
                }
            }
        }

        if (isFetchingDefinition || popupWordDef != null) {
            androidx.compose.ui.window.Dialog(
                onDismissRequest = { 
                    popupWordDef = null 
                    isFetchingDefinition = false 
                }
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        if (isFetchingDefinition) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        } else {
                            popupWordDef?.let { def ->
                                Text(
                                    text = def.word, 
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                )
                                if (def.phonetic.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = def.phonetic, 
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = FontWeight.Medium
                                        ), 
                                        color = PrimaryIndigo
                                    )
                                }
                                if (def.partOfSpeech.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = MaterialTheme.colorScheme.surfaceVariant,
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = def.partOfSpeech, 
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp), 
                                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = def.definition, 
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        lineHeight = 22.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                )
                                
                                if (def.example.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = "Example Usage",
                                        style = MaterialTheme.typography.titleSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Surface(
                                        modifier = Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(8.dp),
                                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                                        border = androidx.compose.foundation.BorderStroke(
                                            width = 1.dp,
                                            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
                                        )
                                    ) {
                                        Text(
                                            text = "\"${def.example}\"",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                                lineHeight = 20.sp
                                            ),
                                            modifier = Modifier.padding(12.dp),
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                                
                                Spacer(modifier = Modifier.height(20.dp))
                                Button(
                                    onClick = { popupWordDef = null },
                                    modifier = Modifier.align(Alignment.End),
                                    colors = ButtonDefaults.buttonColors(containerColor = SecondaryTeal)
                                ) {
                                    Text("Close")
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // --- THEME & MORALE SECTION (Appears after finishing the quiz, only if expanded) ---
        var userMoraleResponse by remember(story.id) { mutableStateOf("") }
        var showAiMorale by remember(story.id) { mutableStateOf(false) }

        AnimatedVisibility(visible = quizSubmitted && isQuizExpanded) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .testTag("morale_section_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Theme & Morale",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                    Text(
                        text = "What do you think is the core lesson or theme of this story?",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    OutlinedTextField(
                        value = userMoraleResponse,
                        onValueChange = { userMoraleResponse = it },
                        modifier = Modifier.fillMaxWidth().height(100.dp),
                        placeholder = { Text("Type your thoughts here...") },
                        shape = RoundedCornerShape(12.dp)
                    )

                    Button(
                        onClick = { showAiMorale = true },
                        enabled = userMoraleResponse.isNotBlank(),
                        colors = ButtonDefaults.buttonColors(containerColor = SecondaryTeal),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Reveal AI Story Morale")
                    }

                    AnimatedVisibility(visible = showAiMorale) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "AI's Morale:",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = PrimaryIndigo
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (story.morale.isNotBlank()) story.morale else "This story doesn't have an explicit morale attached, but great thinking!",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun LegendPill(
    label: String,
    bgColor: Color,
    textColor: Color,
    borderColor: Color
) {
    Surface(
        shape = CircleShape,
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp
            ),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun AnnotationChip(
    text: String,
    badgeLabel: String,
    bgColor: Color,
    textColor: Color,
    borderColor: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 2.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
                shape = CircleShape,
                color = textColor.copy(alpha = 0.15f)
            ) {
                Text(
                    text = badgeLabel,
                    color = textColor,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
        }
    }
}

@Composable
private fun QuizQuestionCard(
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
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        )

        question.options.forEachIndexed { optIndex, optionText ->
            val isSelected = selectedOption == optIndex
            val isCorrect = optIndex == question.correctAnswerIndex

            val optionBgColor = when {
                isSubmitted && isCorrect -> Color(0xFFD1FAE5) // Light Emerald
                isSubmitted && isSelected && !isCorrect -> Color(0xFFFEE2E2) // Light Red
                isSelected -> PrimaryIndigo.copy(alpha = 0.1f)
                else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            }

            val optionBorderColor = when {
                isSubmitted && isCorrect -> Color(0xFF10B981)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                isSelected -> PrimaryIndigo
                else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { onSelectOption(optIndex) },
                color = optionBgColor,
                border = androidx.compose.foundation.BorderStroke(1.dp, optionBorderColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val optionLetter = when (optIndex) {
                        0 -> "A"
                        1 -> "B"
                        2 -> "C"
                        else -> ""
                    }
                    val letterCircleBg = when {
                        isSubmitted && isCorrect -> Color(0xFF10B981)
                        isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                        isSelected -> PrimaryIndigo
                        else -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.15f)
                    }
                    val letterCircleTextColor = when {
                        isSelected || (isSubmitted && isCorrect) || (isSubmitted && isSelected && !isCorrect) -> Color.White
                        else -> MaterialTheme.colorScheme.onSurface
                    }

                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(letterCircleBg),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = optionLetter,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = letterCircleTextColor
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = optionText,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.sp),
                        modifier = Modifier.weight(1f)
                    )

                    if (isSubmitted && isCorrect) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF10B981),
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                text = "Correct",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                ),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    } else if (isSubmitted && isSelected && !isCorrect) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFEF4444),
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                text = "Incorrect",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                ),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }

        if (isSubmitted) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Explanation: ${question.explanation}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}
