package com.gael.gael_practica1.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.gael.gael_practica1.R


val customFontFamily = FontFamily(
    Font(R.font.adlamdisplay_regular)
)

val baseline = Typography()


val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = customFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = customFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = customFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = customFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = customFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = customFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = customFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = customFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = customFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = customFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = customFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = customFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = customFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = customFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = customFontFamily)
)