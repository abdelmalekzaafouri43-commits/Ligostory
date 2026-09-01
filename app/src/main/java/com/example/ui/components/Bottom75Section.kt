package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.togetherWith
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.*
import androidx.compose.ui.layout.layout
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.FormatListBulleted
import com.example.api.DictionaryApi
import com.example.api.WordDefinition
import androidx.compose.material3.CircularProgressIndicator
import com.example.tts.EnglishAccent
import com.example.data.GrammarCategory
import com.example.data.ParsedPart
import com.example.data.QuizQuestion
import com.example.data.StoryData
import com.example.parser.StoryMarkupParser
import com.example.ui.theme.AdjBg
import com.example.ui.theme.AdjBorder
import com.example.ui.theme.AdjText
import com.example.ui.theme.AdvBg
import com.example.ui.theme.AdvBorder
import com.example.ui.theme.AdvText
import com.example.ui.theme.ConjunctionBg
import com.example.ui.theme.ConjunctionBorder
import com.example.ui.theme.ConjunctionText
import com.example.ui.theme.LexiconBg
import com.example.ui.theme.LexiconBorder
import com.example.ui.theme.LexiconText
import com.example.ui.theme.NounBg
import com.example.ui.theme.NounBorder
import com.example.ui.theme.NounText
import com.example.ui.theme.PrepBg
import com.example.ui.theme.PrepBorder
import com.example.ui.theme.PrepText
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.SecondaryTeal
import com.example.ui.theme.Sapphire
import com.example.ui.theme.StructureBg
import com.example.ui.theme.StructureBorder
import com.example.ui.theme.StructureText
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
    
    // Text Size & Accessibility State
    var storyFontSize by remember { mutableFloatStateOf(16f) }
    var showTextSizeSettings by remember { mutableStateOf(false) }

    // Grammar Tag Highlight Toggle & Filter State
    var isGrammarHighlightingEnabled by remember { mutableStateOf(true) }
    var selectedGrammarFilter by remember { mutableStateOf<GrammarCategory?>(null) }
    var showGrammarBreakdown by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    var popupWordDef by remember { mutableStateOf<WordDefinition?>(null) }
    var isFetchingDefinition by remember { mutableStateOf(false) }

    // Map each parsed part to its start and end character index in the plain text
    val partCharRanges = remember(parsedParts) {
        val ranges = mutableListOf<IntRange>()
        var currentIndex = 0
        parsedParts.forEach { part ->
            val text = part.displayString
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
                val text = pagePart.part.displayString
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

        // --- 2. GRAMMAR TAGS & HIGHLIGHT FILTER BAR ---
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            border = androidx.compose.foundation.BorderStroke(
                1.dp,
                if (isGrammarHighlightingEnabled) PrimaryIndigo.copy(alpha = 0.35f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Grammar Highlighting",
                            tint = if (isGrammarHighlightingEnabled) PrimaryIndigo else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                        Column {
                            Text(
                                text = "Grammar Highlighting",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            )
                            Text(
                                text = if (isGrammarHighlightingEnabled) "Study Mode (Tags On)" else "Clean Reading Mode (Off)",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontSize = 10.sp,
                                    color = if (isGrammarHighlightingEnabled) PrimaryIndigo else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (isGrammarHighlightingEnabled) {
                            // Toggle breakdown stats
                            Surface(
                                shape = CircleShape,
                                color = PrimaryIndigo.copy(alpha = 0.1f),
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .clickable { showGrammarBreakdown = !showGrammarBreakdown }
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.FormatListBulleted,
                                        contentDescription = "Breakdown",
                                        tint = PrimaryIndigo,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (showGrammarBreakdown) "Hide" else "Stats",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp,
                                            color = PrimaryIndigo
                                        )
                                    )
                                }
                            }
                        }

                        // Switch toggle
                        Switch(
                            checked = isGrammarHighlightingEnabled,
                            onCheckedChange = { isGrammarHighlightingEnabled = it },
                            modifier = Modifier.testTag("grammar_highlight_switch"),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryIndigo
                            )
                        )
                    }
                }

                // Expandable category pills and statistics when highlighting is enabled
                AnimatedVisibility(visible = isGrammarHighlightingEnabled) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Horizontal scrollable categories filter row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            GrammarFilterPill(
                                label = "All Tags",
                                isSelected = selectedGrammarFilter == null,
                                color = PrimaryIndigo,
                                onClick = { selectedGrammarFilter = null }
                            )
                            GrammarFilterPill(
                                label = "Nouns",
                                isSelected = selectedGrammarFilter == GrammarCategory.NOUN,
                                color = NounText,
                                onClick = { selectedGrammarFilter = GrammarCategory.NOUN }
                            )
                            GrammarFilterPill(
                                label = "Verbs & Tenses",
                                isSelected = selectedGrammarFilter == GrammarCategory.VERB_TENSE,
                                color = TenseText,
                                onClick = { selectedGrammarFilter = GrammarCategory.VERB_TENSE }
                            )
                            GrammarFilterPill(
                                label = "Adjectives",
                                isSelected = selectedGrammarFilter == GrammarCategory.ADJECTIVE,
                                color = AdjText,
                                onClick = { selectedGrammarFilter = GrammarCategory.ADJECTIVE }
                            )
                            GrammarFilterPill(
                                label = "Adverbs",
                                isSelected = selectedGrammarFilter == GrammarCategory.ADVERB,
                                color = AdvText,
                                onClick = { selectedGrammarFilter = GrammarCategory.ADVERB }
                            )
                            GrammarFilterPill(
                                label = "Prepositions",
                                isSelected = selectedGrammarFilter == GrammarCategory.PREPOSITION,
                                color = PrepText,
                                onClick = { selectedGrammarFilter = GrammarCategory.PREPOSITION }
                            )
                            GrammarFilterPill(
                                label = "Conjunctions",
                                isSelected = selectedGrammarFilter == GrammarCategory.CONJUNCTION,
                                color = ConjunctionText,
                                onClick = { selectedGrammarFilter = GrammarCategory.CONJUNCTION }
                            )
                            GrammarFilterPill(
                                label = "Clauses & Structures",
                                isSelected = selectedGrammarFilter == GrammarCategory.SENTENCE_STRUCTURE,
                                color = StructureText,
                                onClick = { selectedGrammarFilter = GrammarCategory.SENTENCE_STRUCTURE }
                            )
                            GrammarFilterPill(
                                label = "Target Vocab",
                                isSelected = selectedGrammarFilter == GrammarCategory.VOCABULARY,
                                color = LexiconText,
                                onClick = { selectedGrammarFilter = GrammarCategory.VOCABULARY }
                            )
                        }

                        // Collapsible Grammar Breakdown Stats
                        AnimatedVisibility(visible = showGrammarBreakdown) {
                            val nounsCount = parsedParts.count { it is ParsedPart.Noun }
                            val verbsCount = parsedParts.count { it is ParsedPart.VerbTense }
                            val adjCount = parsedParts.count { it is ParsedPart.Adjective }
                            val advCount = parsedParts.count { it is ParsedPart.Adverb }
                            val prepCount = parsedParts.count { it is ParsedPart.Preposition }
                            val conjCount = parsedParts.count { it is ParsedPart.Conjunction }
                            val structCount = parsedParts.count { it is ParsedPart.SentenceStructure }
                            val vocabCount = parsedParts.count { it is ParsedPart.Lexicon }

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                                    .background(
                                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                                        RoundedCornerShape(10.dp)
                                    )
                                    .padding(10.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "📊 Grammar Inventory (${parsedParts.filterNot { it is ParsedPart.NormalText }.size} Total Elements)",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                )
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    if (nounsCount > 0) TagStatBadge("Nouns", nounsCount, NounBg, NounText, NounBorder)
                                    if (verbsCount > 0) TagStatBadge("Tenses", verbsCount, TenseBg, TenseText, TenseBorder)
                                    if (adjCount > 0) TagStatBadge("Adjectives", adjCount, AdjBg, AdjText, AdjBorder)
                                    if (advCount > 0) TagStatBadge("Adverbs", advCount, AdvBg, AdvText, AdvBorder)
                                    if (prepCount > 0) TagStatBadge("Prepositions", prepCount, PrepBg, PrepText, PrepBorder)
                                    if (conjCount > 0) TagStatBadge("Conjunctions", conjCount, ConjunctionBg, ConjunctionText, ConjunctionBorder)
                                    if (structCount > 0) TagStatBadge("Structures", structCount, StructureBg, StructureText, StructureBorder)
                                    if (vocabCount > 0) TagStatBadge("Vocabulary", vocabCount, LexiconBg, LexiconText, LexiconBorder)
                                }
                            }
                        }
                    }
                }
            }
        }

        // --- 3. INTERACTIVE STORY READER CONTAINER ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.5.dp,
                    color = Sapphire.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(20.dp)
                )
                .testTag("story_reader_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Sapphire.copy(alpha = 0.07f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📖 Story Text",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Sapphire,
                            fontSize = 15.sp
                        )
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Text Size Quick Access Button
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (showTextSizeSettings) Sapphire else Sapphire.copy(alpha = 0.12f),
                            modifier = Modifier
                                .clickable { showTextSizeSettings = !showTextSizeSettings }
                                .testTag("text_size_setting_button")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Aa",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 13.sp,
                                        color = if (showTextSizeSettings) Color.White else Sapphire
                                    )
                                )
                                Text(
                                    text = "${storyFontSize.toInt()}sp",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        color = if (showTextSizeSettings) Color.White.copy(alpha = 0.9f) else Sapphire.copy(alpha = 0.8f)
                                    )
                                )
                            }
                        }

                        Surface(
                            shape = CircleShape,
                            color = Sapphire.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "Page ${currentPageIndex + 1} of ${storyPages.size}",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    color = Sapphire
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                            )
                        }
                    }
                }

                // Text Size & Accessibility Settings Panel
                AnimatedVisibility(visible = showTextSizeSettings) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 14.dp)
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                RoundedCornerShape(14.dp)
                            )
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "🔤 Story Text Size (${storyFontSize.toInt()} sp)",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            )

                            // Quick Stepper (- / +)
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = Sapphire.copy(alpha = 0.15f),
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(enabled = storyFontSize > 13f) {
                                            storyFontSize = (storyFontSize - 2f).coerceAtLeast(13f)
                                        }
                                        .testTag("decrease_font_size_button")
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "A-",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = if (storyFontSize > 13f) Sapphire else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                                        )
                                    }
                                }

                                Surface(
                                    shape = CircleShape,
                                    color = Sapphire.copy(alpha = 0.15f),
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(enabled = storyFontSize < 24f) {
                                            storyFontSize = (storyFontSize + 2f).coerceAtMost(24f)
                                        }
                                        .testTag("increase_font_size_button")
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "A+",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = if (storyFontSize < 24f) Sapphire else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                                        )
                                    }
                                }
                            }
                        }

                        // Presets
                        val presets = listOf(
                            14f to "Small",
                            16f to "Regular",
                            18f to "Large",
                            21f to "X-Large",
                            24f to "Huge"
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            presets.forEach { (size, label) ->
                                val isSelected = storyFontSize == size
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { storyFontSize = size }
                                        .testTag("font_size_preset_${size.toInt()}"),
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isSelected) Sapphire else MaterialTheme.colorScheme.surface,
                                    border = androidx.compose.foundation.BorderStroke(
                                        1.dp,
                                        if (isSelected) Sapphire else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.padding(vertical = 6.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "${size.toInt()}",
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.sp,
                                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                            )
                                        )
                                        Text(
                                            text = label,
                                            style = MaterialTheme.typography.labelSmall.copy(
                                                fontSize = 9.sp,
                                                color = if (isSelected) Color.White.copy(alpha = 0.85f) else MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

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
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        activePageParts.forEach { pagePart ->
                            val index = pagePart.globalIndex
                            val part = pagePart.part
                            val charRange = partCharRanges.getOrNull(index) ?: IntRange.EMPTY
                            val isWordBeingRead = isPlayingAudio && currentWordRange != null && currentWordRange.first in charRange
                            val isFilterMatched = selectedGrammarFilter == null || part.grammarCategory == selectedGrammarFilter

                            Box(contentAlignment = Alignment.Center) {
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
                                                fontSize = storyFontSize.sp,
                                                lineHeight = (storyFontSize * 1.6f).sp,
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
                                else -> {
                                    if (!isGrammarHighlightingEnabled) {
                                        Text(
                                            text = part.displayString,
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontSize = storyFontSize.sp,
                                                lineHeight = (storyFontSize * 1.6f).sp,
                                                color = if (isWordBeingRead) Color.White else MaterialTheme.colorScheme.onSurface
                                            ),
                                            modifier = Modifier
                                                .then(
                                                    if (isWordBeingRead) {
                                                        Modifier
                                                            .background(PrimaryIndigo, RoundedCornerShape(4.dp))
                                                            .padding(horizontal = 4.dp, vertical = 2.dp)
                                                    } else {
                                                        Modifier
                                                            .clip(RoundedCornerShape(4.dp))
                                                            .clickable { onAnnotationClick(part) }
                                                            .padding(horizontal = 1.dp)
                                                    }
                                                )
                                        )
                                    } else {
                                        val chipFontSize = (storyFontSize * 0.94f).sp
                                        when (part) {
                                            is ParsedPart.NormalText -> { /* handled above */ }
                                            is ParsedPart.Lexicon -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = part.level,
                                                    bgColor = if (isFilterMatched) LexiconBg else LexiconBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) LexiconText else LexiconText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) LexiconBorder else LexiconBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.VerbTense -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Tense",
                                                    bgColor = if (isFilterMatched) TenseBg else TenseBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) TenseText else TenseText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) TenseBorder else TenseBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.Conjunction -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Conj",
                                                    bgColor = if (isFilterMatched) ConjunctionBg else ConjunctionBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) ConjunctionText else ConjunctionText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) ConjunctionBorder else ConjunctionBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.Noun -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Noun",
                                                    bgColor = if (isFilterMatched) NounBg else NounBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) NounText else NounText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) NounBorder else NounBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.Adjective -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Adj",
                                                    bgColor = if (isFilterMatched) AdjBg else AdjBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) AdjText else AdjText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) AdjBorder else AdjBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.Adverb -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Adv",
                                                    bgColor = if (isFilterMatched) AdvBg else AdvBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) AdvText else AdvText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) AdvBorder else AdvBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.Preposition -> {
                                                AnnotationChip(
                                                    text = part.word,
                                                    badgeLabel = "Prep",
                                                    bgColor = if (isFilterMatched) PrepBg else PrepBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) PrepText else PrepText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) PrepBorder else PrepBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                            is ParsedPart.SentenceStructure -> {
                                                AnnotationChip(
                                                    text = part.text,
                                                    badgeLabel = part.structureType,
                                                    bgColor = if (isFilterMatched) StructureBg else StructureBg.copy(alpha = 0.3f),
                                                    textColor = if (isFilterMatched) StructureText else StructureText.copy(alpha = 0.6f),
                                                    borderColor = if (isWordBeingRead) PrimaryIndigo else if (isFilterMatched) StructureBorder else StructureBorder.copy(alpha = 0.3f),
                                                    fontSize = chipFontSize,
                                                    onClick = { onAnnotationClick(part) }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            if (isWordBeingRead) {
                                val infiniteTransition = rememberInfiniteTransition(label = "finger_transition")
                                val bounce by infiniteTransition.animateFloat(
                                    initialValue = 0f,
                                    targetValue = -12f,
                                    animationSpec = infiniteRepeatable(
                                        animation = tween(400, easing = FastOutSlowInEasing),
                                        repeatMode = RepeatMode.Reverse
                                    ),
                                    label = "bounce"
                                )
                                Text(
                                    text = "👇",
                                    fontSize = 24.sp,
                                    modifier = Modifier
                                        .align(Alignment.TopCenter)
                                        .offset { androidx.compose.ui.unit.IntOffset(0, (-32 + bounce).toInt()) }
                                        .layout { measurable, constraints ->
                                            val placeable = measurable.measure(constraints)
                                            layout(0, 0) {
                                                placeable.placeRelative(
                                                    x = -placeable.width / 2,
                                                    y = -placeable.height / 2
                                                )
                                            }
                                        }
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = PrimaryIndigo.copy(alpha = 0.1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = "Quiz",
                                tint = PrimaryIndigo,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(20.dp)
                            )
                        }
                        Text(
                            text = if (isQuizExpanded) "Quiz & Practice" else "Story Comprehension",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = if (isQuizExpanded) MaterialTheme.colorScheme.onSurface else PrimaryIndigo
                            )
                        )
                    }

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
                            text = if (isQuizExpanded) "Hide" else "Start",
                            style = MaterialTheme.typography.labelMedium.copy(
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
private fun GrammarFilterPill(
    label: String,
    isSelected: Boolean,
    color: Color,
    onClick: () -> Unit
) {
    Surface(
        shape = CircleShape,
        color = if (isSelected) color else color.copy(alpha = 0.08f),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isSelected) color else color.copy(alpha = 0.35f)
        ),
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Text(
            text = label,
            color = if (isSelected) Color.White else color,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                fontSize = 11.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun TagStatBadge(
    label: String,
    count: Int,
    bgColor: Color,
    textColor: Color,
    borderColor: Color
) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        ) {
            Text(
                text = "$label: ",
                color = textColor,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = "$count",
                color = textColor,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
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
    fontSize: androidx.compose.ui.unit.TextUnit = 15.sp,
    onClick: () -> Unit
) {
    val badgeSize = (fontSize.value * 0.58f).coerceAtLeast(8.5f).sp
    val horizPadding = (fontSize.value * 0.5f).dp.coerceIn(6.dp, 10.dp)
    val vertPadding = (fontSize.value * 0.2f).dp.coerceIn(2.dp, 5.dp)

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
            modifier = Modifier.padding(horizontal = horizPadding, vertical = vertPadding)
        ) {
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = fontSize
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
                        fontSize = badgeSize,
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
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "$index.",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = PrimaryIndigo
                ),
                modifier = Modifier.padding(end = 8.dp, top = 1.dp)
            )
            Text(
                text = question.question,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            question.options.forEachIndexed { optIndex, optionText ->
                val isSelected = selectedOption == optIndex
                val isCorrect = optIndex == question.correctAnswerIndex

                val optionBgColor = when {
                    isSubmitted && isCorrect -> Color(0xFFD1FAE5) // Light Emerald
                    isSubmitted && isSelected && !isCorrect -> Color(0xFFFEE2E2) // Light Red
                    isSelected -> PrimaryIndigo.copy(alpha = 0.12f)
                    else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                }

                val optionBorderColor = when {
                    isSubmitted && isCorrect -> Color(0xFF10B981)
                    isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                    isSelected -> PrimaryIndigo
                    else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
                }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .clickable(enabled = !isSubmitted) { onSelectOption(optIndex) },
                    color = optionBgColor,
                    border = androidx.compose.foundation.BorderStroke(if (isSelected || isSubmitted && isCorrect) 1.5.dp else 1.dp, optionBorderColor)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val optionLetter = when (optIndex) {
                            0 -> "A"
                            1 -> "B"
                            2 -> "C"
                            3 -> "D"
                            else -> ""
                        }
                        
                        val circleBg = when {
                            isSubmitted && isCorrect -> Color(0xFF10B981)
                            isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                            isSelected -> PrimaryIndigo
                            else -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.15f)
                        }

                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .clip(CircleShape)
                                .background(circleBg),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSubmitted && isCorrect) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Correct",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            } else if (isSubmitted && isSelected && !isCorrect) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Incorrect",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            } else {
                                Text(
                                    text = optionLetter,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                    )
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.width(12.dp))
                        
                        Text(
                            text = optionText,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                fontWeight = if (isSelected || (isSubmitted && isCorrect)) FontWeight.SemiBold else FontWeight.Normal,
                                color = if (isSubmitted && isSelected && !isCorrect) Color(0xFF991B1B) 
                                        else if (isSubmitted && isCorrect) Color(0xFF065F46)
                                        else MaterialTheme.colorScheme.onSurface
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        AnimatedVisibility(visible = isSubmitted) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            ) {
                Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.Top) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = "Explanation",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Explanation",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = question.explanation,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 13.sp,
                                lineHeight = 18.sp
                            )
                        )
                    }
                }
            }
        }
    }
}
