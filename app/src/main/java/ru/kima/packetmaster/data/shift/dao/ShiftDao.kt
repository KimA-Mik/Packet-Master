package ru.kima.packetmaster.data.shift.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.kima.packetmaster.data.shift.entity.OrderEntity
import ru.kima.packetmaster.data.shift.entity.ShiftEntity
import ru.kima.packetmaster.data.shift.entity.ShiftWithOrders

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
    suspend fun insertOrder(orderEntity: OrderEntity): Long

    @Update
    suspend fun updateOrder(orderEntity: OrderEntity)

    @Delete
    suspend fun deleteOrder(orderEntity: OrderEntity)

    @Query("SELECT * FROM ${OrderEntity.TABLE_NAME} WHERE ${OrderEntity.ID_COLUMN_NAME} = :packetId")
    suspend fun getOrder(packetId: Long): OrderEntity?

    @Transaction
    @Query("SELECT * FROM ${ShiftEntity.TABLE_NAME} WHERE ${ShiftEntity.ID_COLUMN_NAME} = :shiftId")
    fun getShiftWithOrders(shiftId: Long): Flow<ShiftWithOrders>
}
