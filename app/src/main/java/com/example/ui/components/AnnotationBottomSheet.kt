package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ParsedPart
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
import com.example.ui.theme.StructureBg
import com.example.ui.theme.StructureBorder
import com.example.ui.theme.StructureText
import com.example.ui.theme.TenseBg
import com.example.ui.theme.TenseBorder
import com.example.ui.theme.TenseText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnotationBottomSheet(
    part: ParsedPart?,
    onDismiss: () -> Unit,
    onSpeakWord: (String) -> Unit,
    sheetState: SheetState
) {
    if (part == null) return

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
    ) {
        val (badgeTitle, themeColor, textBgColor, borderColor) = when (part) {
            is ParsedPart.Lexicon -> Quadruplet("TARGET VOCABULARY", LexiconText, LexiconBg, LexiconBorder)
            is ParsedPart.VerbTense -> Quadruplet("VERB & TENSE", TenseText, TenseBg, TenseBorder)
            is ParsedPart.Conjunction -> Quadruplet("CONJUNCTION & CONNECTOR", ConjunctionText, ConjunctionBg, ConjunctionBorder)
            is ParsedPart.Noun -> Quadruplet("PART OF SPEECH: NOUN", NounText, NounBg, NounBorder)
            is ParsedPart.Adjective -> Quadruplet("PART OF SPEECH: ADJECTIVE", AdjText, AdjBg, AdjBorder)
            is ParsedPart.Adverb -> Quadruplet("PART OF SPEECH: ADVERB", AdvText, AdvBg, AdvBorder)
            is ParsedPart.Preposition -> Quadruplet("PART OF SPEECH: PREPOSITION", PrepText, PrepBg, PrepBorder)
            is ParsedPart.SentenceStructure -> Quadruplet("SENTENCE STRUCTURE / CLAUSE", StructureText, StructureBg, StructureBorder)
            else -> Quadruplet("GRAMMAR ANNOTATION", PrimaryIndigo, MaterialTheme.colorScheme.surfaceVariant, PrimaryIndigo)
        }

        val targetWord = part.displayString

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = textBgColor,
                    border = BorderStroke(1.dp, borderColor)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = badgeTitle,
                            color = themeColor,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 11.sp
                            )
                        )
                    }
                }

                Text(
                    text = "Dismiss",
                    color = themeColor,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

            // Word Heading & Audio Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = targetWord,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier.weight(1f, fill = false)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = { onSpeakWord(targetWord) },
                    colors = ButtonDefaults.buttonColors(containerColor = themeColor),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Speak Word",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Listen",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            // Content Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = textBgColor.copy(alpha = 0.45f)),
                border = BorderStroke(1.dp, borderColor.copy(alpha = 0.6f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    when (part) {
                        is ParsedPart.Lexicon -> {
                            Text(
                                text = "Definition & Level",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.definition,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = themeColor
                            ) {
                                Text(
                                    text = "CEFR Level: ${part.level}",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                        is ParsedPart.VerbTense -> {
                            Text(
                                text = "Grammar Tense: ${part.tenseName}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.Conjunction -> {
                            Text(
                                text = "Syntax Role in Sentence",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.role,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.Noun -> {
                            Text(
                                text = "Noun Role: ${part.role}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.Adjective -> {
                            Text(
                                text = "Adjective (Modifier)",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.Adverb -> {
                            Text(
                                text = "Adverb (${part.type})",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.Preposition -> {
                            Text(
                                text = "Prepositional Function",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        is ParsedPart.SentenceStructure -> {
                            Text(
                                text = "Structure Type: ${part.structureType}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = themeColor
                                )
                            )
                            Text(
                                text = part.explanation,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
                            )
                        }
                        else -> {}
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

private data class Quadruplet<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)

