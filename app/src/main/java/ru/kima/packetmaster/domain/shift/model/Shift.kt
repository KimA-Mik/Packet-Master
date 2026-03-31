package ru.kima.packetmaster.domain.shift.model

import androidx.compose.runtime.Immutable

@Immutable
data class Shift(
    val id: Long,
    val name: String
) {
    companion object {
        fun default(
            id: Long = 0L,
            name: String = ""
        ) = Shift(
            id = id,
            name = name
        )
    }
}