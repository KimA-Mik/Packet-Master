package ru.kima.packetmaster.domain.shift.repositoty

import kotlinx.coroutines.flow.Flow
import ru.kima.packetmaster.domain.shift.model.FullShift
import ru.kima.packetmaster.domain.shift.model.Order
import ru.kima.packetmaster.domain.shift.model.Shift

interface ShiftRepository {
    suspend fun insertShift(shift: Shift): Long
    suspend fun updateShift(shift: Shift)
    suspend fun deleteShift(shift: Shift)
    fun getShifts(): Flow<List<Shift>>
    suspend fun insertPacket(order: Order): Long
    suspend fun updatePacket(order: Order)
    suspend fun deletePacket(order: Order)
    suspend fun getPacket(packetId: Long): Order?
    fun getShiftWithPackets(shiftId: Long): Flow<FullShift>
}