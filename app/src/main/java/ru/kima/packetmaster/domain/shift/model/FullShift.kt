package ru.kima.packetmaster.domain.shift.model

data class FullShift(
    val shift: Shift,
    val packets: List<Packet>
) {
    companion object {
        fun default(
            shift: Shift = Shift.default(),
            packets: List<Packet> = emptyList()
        ) = FullShift(
            shift = shift,
            packets = packets
        )
    }
}
