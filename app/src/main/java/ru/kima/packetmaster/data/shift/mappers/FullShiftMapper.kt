package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.ShiftWithOrders
import ru.kima.packetmaster.domain.shift.model.FullShift

fun ShiftWithOrders.toFullShift(): FullShift {
    return FullShift(
        shift = shift.toShift(),
        orders = orders.map { it.toPacket() }
    )
}