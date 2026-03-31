package ru.kima.packetmaster.ui.util

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import ru.kima.packetmaster.ui.navigation.Navigator

val LocalNavigator = compositionLocalOf<Navigator> {
    error("CompositionLocal Navigator not presented")
}

val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> {
    error("CompositionLocal SnackbarHostState not presented")
}

@Composable
fun ProvideContentColorTextStyle(
    contentColor: Color,
    textStyle: TextStyle,
    content: @Composable () -> Unit,
) {
    val mergedStyle = LocalTextStyle.current.merge(textStyle)
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalTextStyle provides mergedStyle,
        content = content,
    )
}
