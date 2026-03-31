package ru.kima.packetmaster.data.shift.entity

import androidx.room.Embedded
import androidx.room.Relation


data class ShiftWithOrders(
    @Embedded val shift: ShiftEntity,
    @Relation(
        parentColumn = ShiftEntity.ID_COLUMN_NAME,
        entityColumn = OrderEntity.PARENT_COLUMN_NAME
    )
    val orders: List<OrderEntity>
)