package com.example.androidjetpackcomposeui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColorScheme(
    primary = NeonGreen,
    secondary = NeonYellow,
    background = SoftWhite,
    surface = Color.White,
    onPrimary = BoldBlack,
    onBackground = BoldBlack,
    onSurface = BoldBlack,
    onSecondary = BoldBlack
)

private val DarkColorPalette = darkColorScheme(
    primary = NeonAccent,
    secondary = NeonYellow,
    background = BoldBlack,
    surface = DarkGray,
    onPrimary = SoftWhite,
    onBackground = SoftWhite,
    onSurface = SoftWhite,
    onSecondary = BoldBlack
)

@Composable
fun MaxFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    MaterialTheme(
        colorScheme = colors,
        typography = MaxFitTypography,
        content = content
    )
}

fun primaryGradientBrush(): Brush = Brush.verticalGradient(
    colors = listOf(PrimaryGradientStart, PrimaryGradientEnd)
)

fun accentGradientBrush(): Brush = Brush.horizontalGradient(
    colors = listOf(AccentGradientStart, AccentGradientEnd)
)
