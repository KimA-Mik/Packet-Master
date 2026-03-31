package ru.kima.packetmaster.domain.shift.model

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