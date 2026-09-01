package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class AppThemePalette(
    val label: String,
    val primaryColor: Color,
    val secondaryColor: Color,
    val tertiaryColor: Color,
    val darkPrimary: Color,
    val darkSecondary: Color,
    val darkTertiary: Color,
    val darkBackground: Color = Color(0xFF0F172A),
    val darkSurface: Color = Color(0xFF1E293B)
) {
    INDIGO(
        label = "Indigo",
        primaryColor = PrimaryIndigo,
        secondaryColor = SecondaryTeal,
        tertiaryColor = TertiaryAmber,
        darkPrimary = DarkPrimaryIndigo,
        darkSecondary = DarkSecondaryTeal,
        darkTertiary = DarkTertiaryAmber
    ),
    SAPPHIRE(
        label = "Sapphire",
        primaryColor = Color(0xFF0F52BA),
        secondaryColor = Color(0xFF0284C7),
        tertiaryColor = Color(0xFF38BDF8),
        darkPrimary = Color(0xFF60A5FA),
        darkSecondary = Color(0xFF38BDF8),
        darkTertiary = Color(0xFF93C5FD),
        darkBackground = Color(0xFF070E1E),
        darkSurface = Color(0xFF0F1E3D)
    ),
    EMERALD(
        label = "Emerald",
        primaryColor = Color(0xFF059669),
        secondaryColor = Color(0xFF0D9488),
        tertiaryColor = Color(0xFF10B981),
        darkPrimary = Color(0xFF34D399),
        darkSecondary = Color(0xFF2DD4BF),
        darkTertiary = Color(0xFF6EE7B7),
        darkBackground = Color(0xFF051713),
        darkSurface = Color(0xFF0D2821)
    ),
    RUBY(
        label = "Ruby",
        primaryColor = Color(0xFFE11D48),
        secondaryColor = Color(0xFFBE123C),
        tertiaryColor = Color(0xFFFB7185),
        darkPrimary = Color(0xFFFB7185),
        darkSecondary = Color(0xFFFDA4AF),
        darkTertiary = Color(0xFFFECDD3),
        darkBackground = Color(0xFF1A060B),
        darkSurface = Color(0xFF2B0E16)
    ),
    AMETHYST(
        label = "Amethyst",
        primaryColor = Color(0xFF7C3AED),
        secondaryColor = Color(0xFF9333EA),
        tertiaryColor = Color(0xFFC084FC),
        darkPrimary = Color(0xFFA78BFA),
        darkSecondary = Color(0xFFC084FC),
        darkTertiary = Color(0xFFDDD6FE),
        darkBackground = Color(0xFF120824),
        darkSurface = Color(0xFF221142)
    ),
    AMBER(
        label = "Amber",
        primaryColor = Color(0xFFD97706),
        secondaryColor = Color(0xFFB45309),
        tertiaryColor = Color(0xFFFBBF24),
        darkPrimary = Color(0xFFFBBF24),
        darkSecondary = Color(0xFFFCD34D),
        darkTertiary = Color(0xFFFEF08A),
        darkBackground = Color(0xFF181003),
        darkSurface = Color(0xFF2A1C08)
    );

    fun buildColorScheme(isDark: Boolean): ColorScheme {
        return if (isDark) {
            darkColorScheme(
                primary = darkPrimary,
                secondary = darkSecondary,
                tertiary = darkTertiary,
                background = darkBackground,
                surface = darkSurface,
                onPrimary = Color.White,
                onBackground = Color(0xFFF1F5F9),
                onSurface = Color(0xFFF1F5F9)
            )
        } else {
            lightColorScheme(
                primary = primaryColor,
                secondary = secondaryColor,
                tertiary = tertiaryColor,
                background = BackgroundSoft,
                surface = SurfaceCard,
                onPrimary = Color.White,
                onBackground = OnSurfacePrimary,
                onSurface = OnSurfacePrimary
            )
        }
    }
}

@Composable
fun LingoStoryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    palette: AppThemePalette = AppThemePalette.INDIGO,
    content: @Composable () -> Unit
) {
    val colorScheme = palette.buildColorScheme(darkTheme)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

