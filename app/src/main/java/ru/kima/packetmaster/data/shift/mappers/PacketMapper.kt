package ru.kima.packetmaster.data.shift.mappers

import ru.kima.packetmaster.data.shift.entity.PacketEntity
import ru.kima.packetmaster.domain.shift.model.Packet

fun PacketEntity.toPacket() = Packet(
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

fun Packet.toEntity() = PacketEntity(
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