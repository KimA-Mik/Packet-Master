package ru.kima.packetmaster.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kima.packetmaster.data.shift.dao.ShiftDao
import ru.kima.packetmaster.data.shift.entity.OrderEntity
import ru.kima.packetmaster.data.shift.entity.ShiftEntity

@Database(
    entities = [
        ShiftEntity::class,
        OrderEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shiftDao(): ShiftDao

    companion object {
        const val NAME = "app_database"
    }
}