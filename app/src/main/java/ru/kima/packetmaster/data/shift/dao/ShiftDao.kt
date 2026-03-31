package ru.kima.packetmaster.data.shift.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.kima.packetmaster.data.shift.entity.PacketEntity
import ru.kima.packetmaster.data.shift.entity.ShiftEntity
import ru.kima.packetmaster.data.shift.entity.ShiftWithPackets

@Dao
interface ShiftDao {
    @Insert
    suspend fun insertShift(shift: ShiftEntity): Long

    @Update
    suspend fun updateShift(shift: ShiftEntity)

    @Delete
    suspend fun deleteShift(shift: ShiftEntity)

    @Query("SELECT * FROM ${ShiftEntity.TABLE_NAME}")
    fun getShifts(): Flow<List<ShiftEntity>>

    @Insert
    suspend fun insertPacket(packetEntity: PacketEntity): Long

    @Insert
    suspend fun updatePacket(packetEntity: PacketEntity)

    @Delete
    suspend fun deletePacket(packetEntity: PacketEntity)

    @Query("SELECT * FROM ${PacketEntity.TABLE_NAME} WHERE ${PacketEntity.ID_COLUMN_NAME} = :packetId")
    suspend fun getPacket(packetId: Long): PacketEntity?

    @Transaction
    @Query("SELECT * FROM ${ShiftEntity.TABLE_NAME} WHERE ${ShiftEntity.ID_COLUMN_NAME} = :shiftId")
    fun getShiftWithPackets(shiftId: Long): Flow<ShiftWithPackets>
}
