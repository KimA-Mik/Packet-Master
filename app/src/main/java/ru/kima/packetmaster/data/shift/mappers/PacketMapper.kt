package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.PacketEntity
import ru.kima.packetmaster.domain.shift.model.Order

fun PacketEntity.toPacket() = Order(
    id = id,
    name = name,
    shiftId = shiftId,
    dryMaximum = dryMaximum,
    drySelected = drySelected,
    cooledMaximum = cooledMaximum,
    cooledSelected = cooledSelected,
    frozenMaximum = frozenMaximum,
    frozenSelected = frozenSelected,
)

fun Order.toEntity() = PacketEntity(
    id = id,
    name = name,
    shiftId = shiftId,
    dryMaximum = dryMaximum,
    drySelected = drySelected,
    cooledMaximum = cooledMaximum,
    cooledSelected = cooledSelected,
    frozenMaximum = frozenMaximum,
    frozenSelected = frozenSelected,
)