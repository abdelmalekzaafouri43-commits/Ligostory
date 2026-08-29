package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.window.Dialog
import com.example.data.CefrLevel
import com.example.data.PresetStories
import com.example.data.StoryData
import com.example.data.StoryTheme
import com.example.ui.theme.PrimaryIndigo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StorySelectorDialog(
    currentStory: StoryData,
    savedStories: List<StoryData> = emptyList(),
    onSelectStory: (StoryData) -> Unit,
    onGenerateAiStory: (CefrLevel, StoryTheme) -> Unit,
    isGenerating: Boolean,
    onDismiss: () -> Unit
) {
    var selectedLevel by remember { mutableStateOf(currentStory.level) }
    var selectedTheme by remember { mutableStateOf(currentStory.theme) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Book,
                            contentDescription = "Library",
                            tint = PrimaryIndigo,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Story Library & Level",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp
                            )
                        )
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Divider()

                // Level Selection
                Text(
                    text = "1. Target Level (CEFR)",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    CefrLevel.entries.forEach { level ->
                        val isSelected = selectedLevel == level
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { selectedLevel = level },
                            color = if (isSelected) Color(level.badgeColorHex) else MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = level.label.split(" ").last(), // e.g. A2, B1, C1
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                ),
                                modifier = Modifier.padding(vertical = 8.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }

                // Theme Selection
                Text(
                    text = "2. Theme",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    StoryTheme.entries.forEach { theme ->
                        val isSelected = selectedTheme == theme
                        Surface(
                            shape = CircleShape,
                            color = if (isSelected) PrimaryIndigo else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.clickable { selectedTheme = theme }
                        ) {
                            Text(
                                text = theme.label,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }
                    }
                }

                Divider()

                // Generate AI Story Button
                Button(
                    onClick = { onGenerateAiStory(selectedLevel, selectedTheme) },
                    enabled = !isGenerating,
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("dialog_generate_ai_button")
                ) {
                    if (isGenerating) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Generating AI Story...")
                    } else {
                        Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = "Generate")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("✨ Generate New AI Story")
                    }
                }

                // Saved / Bookmarked Stories List
                if (savedStories.isNotEmpty()) {
                    Text(
                        text = "Saved Stories (${savedStories.size}):",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigo
                        )
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(savedStories) { story ->
                            val isCurrent = story.id == currentStory.id
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onSelectStory(story)
                                        onDismiss()
                                    },
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (isCurrent) PrimaryIndigo.copy(alpha = 0.2f) else MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "💾 ${story.title}",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 13.sp
                                            )
                                        )
                                        Text(
                                            text = "${story.level.label} • ${story.theme.label}",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                fontSize = 11.sp
                                            )
                                        )
                                    }
                                    if (isCurrent) {
                                        Surface(shape = CircleShape, color = PrimaryIndigo) {
                                            Text(
                                                text = "Active",
                                                color = Color.White,
                                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }

                // Preset Stories List
                Text(
                    text = "Curated Library Stories:",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                val filteredStories = PresetStories.stories.filter {
                    it.level == selectedLevel || it.theme == selectedTheme
                }.ifEmpty { PresetStories.stories }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredStories) { story ->
                        val isCurrent = story.id == currentStory.id
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSelectStory(story)
                                    onDismiss()
                                },
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isCurrent) PrimaryIndigo.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            ),
                            border = if (isCurrent) androidx.compose.foundation.BorderStroke(1.5.dp, PrimaryIndigo) else null
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = story.title,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp
                                        )
                                    )
                                    Text(
                                        text = "${story.level.label} • ${story.theme.label}",
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            fontSize = 11.sp
                                        )
                                    )
                                }
                                if (isCurrent) {
                                    Surface(shape = CircleShape, color = PrimaryIndigo) {
                                        Text(
                                            text = "Active",
                                            color = Color.White,
                                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
