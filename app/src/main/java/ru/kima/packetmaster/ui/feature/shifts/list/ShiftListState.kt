package ru.kima.packetmaster.ui.feature.shifts.list

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import ru.kima.packetmaster.domain.shift.model.Shift

@Immutable
data class ShiftListState(
    val shifts: ImmutableList<Shift>,
) {
    companion object {
        fun default(
            shifts: List<Shift> = emptyList()
        ) = ShiftListState(
            shifts = shifts.toImmutableList()
        )
    }
}
