package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.ShiftWithPackets
import ru.kima.packetmaster.domain.shift.model.FullShift

fun ShiftWithPackets.toFullShift(): FullShift {
    return FullShift(
        shift = shift.toShift(),
        orders = packets.map { it.toPacket() }
    )
}