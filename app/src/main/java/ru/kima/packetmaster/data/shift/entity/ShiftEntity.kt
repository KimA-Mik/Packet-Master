package ru.kima.packetmaster.data.shift.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ShiftEntity.TABLE_NAME)
data class ShiftEntity(
    @PrimaryKey
    @ColumnInfo(name = ID_COLUMN_NAME)
    val id: Long,
    val name: String,
) {
    companion object {
        const val TABLE_NAME = "shifts"
        const val ID_COLUMN_NAME = "id"
    }
}
