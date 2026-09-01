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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.asImageBitmap
import coil.compose.AsyncImage
import com.example.api.ImagenStoryIllustrator
import com.example.data.StoryData
import com.example.ui.theme.AppThemePalette
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.SecondaryTeal

@Composable
fun Top25Section(
    story: StoryData,
    onOpenLibrary: () -> Unit,
    onSaveStory: () -> Unit,
    onSaveImageToGallery: () -> Unit = {},
    onGenerateAiStory: () -> Unit,
    onGenerateImagenArt: () -> Unit = {},
    isGenerating: Boolean,
    isGeneratingImage: Boolean = false,
    readingProgress: Float,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    currentPalette: AppThemePalette = AppThemePalette.INDIGO,
    onSelectPalette: (AppThemePalette) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var showPromptDetails by remember { mutableStateOf(false) }
    var showPaletteDialog by remember { mutableStateOf(false) }

    val decodedBitmap = remember(story.generatedImageBase64) {
        story.generatedImageBase64?.let { ImagenStoryIllustrator.decodeBase64ToBitmap(it) }
    }

    if (showPaletteDialog) {
        AlertDialog(
            onDismissRequest = { showPaletteDialog = false },
            title = {
                Text(
                    text = "Select App Theme Palette",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Choose your preferred gemstone & color aesthetic:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f)
                    )
                    AppThemePalette.values().forEach { paletteOption ->
                        val isSelected = paletteOption == currentPalette
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .border(
                                    width = if (isSelected) 2.dp else 1.dp,
                                    color = if (isSelected) paletteOption.primaryColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable {
                                    onSelectPalette(paletteOption)
                                    showPaletteDialog = false
                                },
                            color = if (isSelected) paletteOption.primaryColor.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    // Palette Swatch
                                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Box(
                                            modifier = Modifier
                                                .width(16.dp)
                                                .height(16.dp)
                                                .clip(CircleShape)
                                                .background(paletteOption.primaryColor)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .width(16.dp)
                                                .height(16.dp)
                                                .clip(CircleShape)
                                                .background(paletteOption.secondaryColor)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .width(16.dp)
                                                .height(16.dp)
                                                .clip(CircleShape)
                                                .background(paletteOption.tertiaryColor)
                                        )
                                    }
                                    Text(
                                        text = paletteOption.label,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                        ),
                                        color = if (isSelected) paletteOption.primaryColor else MaterialTheme.colorScheme.onSurface
                                    )
                                }
                                if (isSelected) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = paletteOption.primaryColor
                                    ) {
                                        Text(
                                            text = "Active",
                                            color = Color.White,
                                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showPaletteDialog = false }) {
                    Text("Done", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("top_25_section_card"),
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Illustration Banner (Imagen / Base64 / Remote / Local / Fallback)
            if (decodedBitmap != null) {
                Image(
                    bitmap = decodedBitmap.asImageBitmap(),
                    contentDescription = "Imagen Chapter Illustration",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else if (story.generatedImageUrl != null) {
                AsyncImage(
                    model = story.generatedImageUrl,
                    contentDescription = "Imagen Chapter Illustration",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else if (story.localDrawableRes != null) {
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
                        text = "Welcome, Guest Learner",
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
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Theme Palette Picker Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(currentPalette.primaryColor.copy(alpha = 0.75f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.45f), shape = RoundedCornerShape(8.dp))
                                .clickable { showPaletteDialog = true }
                                .padding(horizontal = 9.dp, vertical = 6.dp)
                                .testTag("theme_palette_button")
                        ) {
                            Text(
                                text = currentPalette.label,
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            )
                        }

                        // Theme Dark/Light Toggle Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.35f), shape = RoundedCornerShape(8.dp))
                                .clickable { onToggleDarkTheme() }
                                .padding(horizontal = 9.dp, vertical = 6.dp)
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

                        // Save Image to Gallery Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(width = 1.dp, color = Color.White.copy(alpha = 0.35f), shape = RoundedCornerShape(8.dp))
                                .clickable { onSaveImageToGallery() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("save_image_button")
                        ) {
                            Text(
                                text = "Save Gallery",
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

                        // Generate Imagen Art Text Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isGeneratingImage) Color.Gray.copy(alpha = 0.3f) else Color(0xFFE11D48))
                                .border(
                                    width = 1.dp,
                                    color = if (isGeneratingImage) Color.White.copy(alpha = 0.2f) else Color.White.copy(alpha = 0.45f),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable(enabled = !isGeneratingImage) { onGenerateImagenArt() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("generate_imagen_button")
                        ) {
                            Text(
                                text = if (isGeneratingImage) "Drawing..." else "Imagen",
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
