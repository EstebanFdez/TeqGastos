package com.example.teqgastos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = VerdePrincipal,
    onPrimary = Color.White,
    secondary = TurquesaAcento,
    background = FondoLimpio,
    surface = Color.White,
    onBackground = Color(0xFF191C1C),
    onSurface = Color(0xFF191C1C)
)

@Composable
fun TeqGastosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Usamos el esquema claro para mantener la estética fija del prototipo corporativo
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}