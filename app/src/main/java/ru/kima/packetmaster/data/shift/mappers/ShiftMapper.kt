package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.ShiftEntity
import ru.kima.packetmaster.domain.shift.model.Shift

fun ShiftEntity.toShift() = Shift(
    id = id,
    name = name
)

fun Shift.toEntity() = ShiftEntity(
    id = id,
    name = name
)