package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.foundation.layout.fillMaxWidth
import coil.compose.AsyncImage
import com.example.data.StoryData
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.SecondaryTeal

@Composable
fun Top25Section(
    story: StoryData,
    onOpenLibrary: () -> Unit,
    onSaveStory: () -> Unit,
    onGenerateAiStory: () -> Unit,
    isGenerating: Boolean,
    readingProgress: Float,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showPromptDetails by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("top_25_section_card"),
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Illustration Banner
            if (story.localDrawableRes != null) {
                Image(
                    painter = painterResource(id = story.localDrawableRes),
                    contentDescription = "Story Banner Illustration",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else if (story.imagePrompt.isNotBlank()) {
                val encodedPrompt = java.net.URLEncoder.encode(story.imagePrompt, "UTF-8")
                val imageUrl = "https://image.pollinations.ai/prompt/${encodedPrompt}?width=800&height=400&nologo=true"
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Story Banner Illustration",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(PrimaryIndigo, SecondaryTeal)
                            )
                        )
                )
            }

            // Dark Gradient Overlay for readability
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.55f),
                                Color.Black.copy(alpha = 0.85f)
                            )
                        )
                    )
            )

            // Content Overlay
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp, vertical = 14.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Greeting and Badges
                Column {
                    Text(
                        text = "Welcome, Mr.Zaafouri Abdelmalek",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                // Header Top Row: Badges & Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // CEFR Level Badge
                        Surface(
                            shape = CircleShape,
                            color = Color(story.level.badgeColorHex),
                            shadowElevation = 2.dp
                        ) {
                            Text(
                                text = story.level.label,
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        // Theme Badge
                        Surface(
                            shape = CircleShape,
                            color = Color.White.copy(alpha = 0.25f)
                        ) {
                            Text(
                                text = story.theme.label,
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    // Selector & AI Story Generator Buttons - Text Only (No Icons)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Theme Toggle Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.35f), shape = RoundedCornerShape(8.dp))
                                .clickable { onToggleDarkTheme() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("theme_toggle_button")
                        ) {
                            Text(
                                text = if (isDarkTheme) "Light" else "Dark",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }
                        
                        // Open Library Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.35f), shape = RoundedCornerShape(8.dp))
                                .clickable { onOpenLibrary() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("open_library_button")
                        ) {
                            Text(
                                text = "Library",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }

                        // Save Story Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.35f), shape = RoundedCornerShape(8.dp))
                                .clickable { onSaveStory() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("save_story_button")
                        ) {
                            Text(
                                text = "Save",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }

                        // Generate AI Story Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isGenerating) Color.Gray.copy(alpha = 0.3f) else PrimaryIndigo)
                                .border(
                                    width = 1.dp,
                                    color = if (isGenerating) Color.White.copy(alpha = 0.2f) else Color.White.copy(alpha = 0.45f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable(enabled = !isGenerating) { onGenerateAiStory() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("generate_ai_button")
                        ) {
                            Text(
                                text = if (isGenerating) "Writing..." else "AI Gen",
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }
                }
                }

                // Title & Prompt Description Info
                Column(modifier = Modifier.padding(top = 4.dp)) {
                    Text(
                        text = story.title,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 20.sp
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .clickable { showPromptDetails = !showPromptDetails }
                            .padding(vertical = 2.dp)
                    ) {
                        Text(
                            text = if (showPromptDetails) "Hide Illustration Prompt" else "Show Illustration Prompt",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = SecondaryTeal,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                    AnimatedVisibility(visible = showPromptDetails) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.Black.copy(alpha = 0.6f),
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "🎨 Image Prompt: ${story.imagePrompt}",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.White.copy(alpha = 0.9f),
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            // Progress Bar at the bottom
            val animatedProgress by animateFloatAsState(targetValue = readingProgress, label = "progress")
            LinearProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .align(Alignment.BottomStart),
                color = SecondaryTeal,
                trackColor = Color.White.copy(alpha = 0.3f),
                strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
            )
        }
    }
}
