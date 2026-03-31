package ru.kima.packetmaster.ui.feature.shifts.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

object ShiftsGraph {
    @Serializable
    object List : NavKey {
        @Serializable
        data class Details(val shiftId: Long) : NavKey
    }
}