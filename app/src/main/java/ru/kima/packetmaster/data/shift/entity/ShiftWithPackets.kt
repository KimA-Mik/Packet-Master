package ru.kima.packetmaster.data.shift.entity

import androidx.room.Embedded
import androidx.room.Relation


data class ShiftWithPackets(
    @Embedded val shift: ShiftEntity,
    @Relation(
        parentColumn = ShiftEntity.ID_COLUMN_NAME,
        entityColumn = PacketEntity.PARENT_COLUMN_NAME
    )
    val packets: List<PacketEntity>
)