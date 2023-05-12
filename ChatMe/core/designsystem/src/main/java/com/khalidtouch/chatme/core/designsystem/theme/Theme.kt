package com.khalidtouch.chatme.core.designsystem.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
    primary = Green40,
    onPrimary = Color.White,
    primaryContainer = Green40,
    onPrimaryContainer = Color.White,
    secondary = DarkGreen20,
    onSecondary = Color.White,
    secondaryContainer = DarkGreen40,
    onSecondaryContainer = DarkGreenGray10,
    tertiary = Green20,
    onTertiary = Color.White,
    tertiaryContainer = Green40,
    onTertiaryContainer = Green10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Color.White,
    onBackground = Green40,
    surface = Color.White,
    onSurface = Green40,
    surfaceVariant = Green80,
    onSurfaceVariant = Green00,
    inverseSurface = DarkGreen20,
    inverseOnSurface = DarkGreen10,
    outline = Green90,
)


@VisibleForTesting
val DarkDefaultColorScheme = darkColorScheme(
    primary = Green10,
    onPrimary = Color.White,
    primaryContainer = Green00,
    onPrimaryContainer = Color.White,
    secondary = Green00,
    onSecondary = Color.White,
    secondaryContainer = Green30,
    onSecondaryContainer = Green00,
    tertiary = Green00,
    onTertiary = Color.White,
    tertiaryContainer = Green20,
    onTertiaryContainer = Green00,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Green00,
    onBackground = Color.White,
    surface = Green00,
    onSurface = Color.White,
    surfaceVariant = Green10,
    onSurfaceVariant = Green40,
    inverseSurface = Green90,
    inverseOnSurface = Green00,
    outline = Green10,
)

@VisibleForTesting
val LightAndroidColorScheme = lightColorScheme(
    primary = Green10,
    onPrimary = Color.White,
    primaryContainer = Green40,
    onPrimaryContainer = Color.White,
    secondary = DarkGreen20,
    onSecondary = Color.White,
    secondaryContainer = DarkGreen40,
    onSecondaryContainer = DarkGreenGray10,
    tertiary = Green20,
    onTertiary = Color.White,
    tertiaryContainer = Green40,
    onTertiaryContainer = Green10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkPurpleGray99,
    onBackground = DarkPurpleGray10,
    surface = Green00,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    inverseSurface = DarkPurpleGray20,
    inverseOnSurface = DarkPurpleGray95,
    outline = PurpleGray50,
)


@VisibleForTesting
val DarkAndroidColorScheme = darkColorScheme(
    primary = Green10,
    onPrimary = Color.White,
    primaryContainer = Green00,
    onPrimaryContainer = Color.White,
    secondary = Green00,
    onSecondary = Color.White,
    secondaryContainer = Green30,
    onSecondaryContainer = Green00,
    tertiary = Green00,
    onTertiary = Color.White,
    tertiaryContainer = Green20,
    onTertiaryContainer = Green00,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Green00,
    onBackground = Color.White,
    surface = Green00,
    onSurface = Color.White,
    surfaceVariant = Green10,
    onSurfaceVariant = Green40,
    inverseSurface = Green90,
    inverseOnSurface = Green00,
    outline = Green10,
)

val LightAndroidBackgroundTheme = BackgroundTheme(color = DarkGreenGray95)

val DarkAndroidBackgroundTheme = BackgroundTheme(color = Green00)

@Composable
fun CMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        androidTheme -> if (darkTheme) DarkAndroidColorScheme else LightAndroidColorScheme
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
    }


    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp
    )

    val backgroundTheme = when {
        androidTheme -> if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
        else -> defaultBackgroundTheme
    }

    val tintTheme = when {
        androidTheme -> TintTheme()
        !disableDynamicTheming && supportsDynamicTheming() -> TintTheme(colorScheme.primary)
        else -> TintTheme()
    }

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme,
        LocalTintTheme provides tintTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CMTypography,
            content = content,
        )
    }


}


@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
