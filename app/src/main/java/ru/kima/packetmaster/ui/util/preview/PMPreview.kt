package ru.kima.packetmaster.ui.util.preview

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import ru.kima.packetmaster.ui.navigation.Navigator
import ru.kima.packetmaster.ui.navigation.rememberNavigationState
import ru.kima.packetmaster.ui.theme.PacketMasterTheme
import ru.kima.packetmaster.ui.util.LocalNavigator
import ru.kima.packetmaster.ui.util.LocalSnackbarHostState

@Composable
fun isNightMode() = when (AppCompatDelegate.getDefaultNightMode()) {
    AppCompatDelegate.MODE_NIGHT_NO -> false
    AppCompatDelegate.MODE_NIGHT_YES -> true
    else -> isSystemInDarkTheme()
}

@Serializable
private object DummyNavKey : NavKey

@Composable
fun PMPreview(
    darkTheme: Boolean = isNightMode(),
    isAmoled: Boolean = false,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val navigationState = rememberNavigationState(DummyNavKey, setOf(DummyNavKey))
    CompositionLocalProvider(
        LocalNavigator provides remember { Navigator(navigationState) },
        LocalSnackbarHostState provides remember { SnackbarHostState() },
    ) {
        PacketMasterTheme(
            darkTheme = darkTheme,
            dynamicColor = dynamicColor
        ) {
            content()
        }
    }
}