package com.gael.gael_practica1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    background = backgroundLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight
)

@Composable
fun Gael_practica1Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightScheme,
        typography = AppTypography,
        content = content
    )
}