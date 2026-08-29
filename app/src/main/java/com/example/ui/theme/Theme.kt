package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryIndigo,
    secondary = DarkSecondaryTeal,
    tertiary = DarkTertiaryAmber,
    background = DarkBackground,
    surface = DarkSurfaceCard,
    onPrimary = Color.White,
    onBackground = Color(0xFFF1F5F9),
    onSurface = Color(0xFFF1F5F9)
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryIndigo,
    secondary = SecondaryTeal,
    tertiary = TertiaryAmber,
    background = BackgroundSoft,
    surface = SurfaceCard,
    onPrimary = Color.White,
    onBackground = OnSurfacePrimary,
    onSurface = OnSurfacePrimary
)

@Composable
fun LingoStoryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
