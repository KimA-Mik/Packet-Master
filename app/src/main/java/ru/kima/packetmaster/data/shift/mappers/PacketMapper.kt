package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.OrderEntity
import ru.kima.packetmaster.domain.shift.model.Order

fun OrderEntity.toPacket() = Order(
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

fun Order.toEntity() = OrderEntity(
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