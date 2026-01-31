package com.gael.gael_practica1.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.gael.gael_practica1.R // Importante para encontrar tus recursos

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val adlamFontFamily = FontFamily(
    Font(googleFont = GoogleFont("ADLaM Display"), fontProvider = provider)
)

val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = adlamFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = adlamFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = adlamFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = adlamFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = adlamFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = adlamFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = adlamFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = adlamFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = adlamFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = adlamFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = adlamFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = adlamFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = adlamFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = adlamFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = adlamFontFamily),
)