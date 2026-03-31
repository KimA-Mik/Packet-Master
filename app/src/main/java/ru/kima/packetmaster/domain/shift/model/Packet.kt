package ru.kima.packetmaster.domain.shift.model

data class Packet(
    val id: Long,
    val name: String,
    val shiftId: Long,
    val dryMaximum: Int,
    val drySelected: Int,
    val cooledMaximum: Int,
    val cooledSelected: Int,
    val frozenMaximum: Int,
    val frozenSelected: Int,
) {
    companion object {
        fun default(
            id: Long = 0L,
            name: String = "",
            shiftId: Long = 0L,
            dryMaximum: Int = 0,
            drySelected: Int = 0,
            cooledMaximum: Int = 0,
            cooledSelected: Int = 0,
            frozenMaximum: Int = 0,
            frozenSelected: Int = 0
        ) = Packet(
            id = id,
            name = name,
            shiftId = shiftId,
            dryMaximum = dryMaximum,
            drySelected = drySelected,
            cooledMaximum = cooledMaximum,
            cooledSelected = cooledSelected,
            frozenMaximum = frozenMaximum,
            frozenSelected = frozenSelected
        )
    }
}