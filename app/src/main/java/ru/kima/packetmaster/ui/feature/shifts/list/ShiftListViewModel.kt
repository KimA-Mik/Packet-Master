package ru.kima.packetmaster.ui.feature.shifts.list

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.kima.packetmaster.domain.shift.repositoty.ShiftRepository

@Stable
class ShiftListViewModel(
    private val repository: ShiftRepository
) : ViewModel() {
    val state = repository.getShifts().map { shifts ->
        ShiftListState(shifts.toImmutableList())
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ShiftListState.default())
}