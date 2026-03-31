package ru.kima.packetmaster.data.shift.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = OrderEntity.TABLE_NAME)
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_NAME)
    val id: Long,
    val name: String,
    @ColumnInfo(name = PARENT_COLUMN_NAME) val shiftId: Long,
    @ColumnInfo(name = "dry_maximum") val dryMaximum: Int,
    @ColumnInfo(name = "dry_selected") val drySelected: Int,
    @ColumnInfo(name = "cooled_maximum") val cooledMaximum: Int,
    @ColumnInfo(name = "cooled_selected") val cooledSelected: Int,
    @ColumnInfo(name = "frozen_maximum") val frozenMaximum: Int,
    @ColumnInfo(name = "frozen_selected") val frozenSelected: Int,
) {
    companion object {
        const val TABLE_NAME = "orders"
        const val ID_COLUMN_NAME = "id"
        const val PARENT_COLUMN_NAME = "shift_id"
    }
}
