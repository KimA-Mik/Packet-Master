package ru.kima.packetmaster.domain.shift.repositoty

import kotlinx.coroutines.flow.Flow
import ru.kima.packetmaster.domain.shift.model.FullShift
import ru.kima.packetmaster.domain.shift.model.Packet
import ru.kima.packetmaster.domain.shift.model.Shift

interface ShiftRepository {
    suspend fun insertShift(shift: Shift): Long
    suspend fun updateShift(shift: Shift)
    suspend fun deleteShift(shift: Shift)
    fun getShifts(): Flow<List<Shift>>
    suspend fun insertPacket(packet: Packet): Long
    suspend fun updatePacket(packet: Packet)
    suspend fun deletePacket(packet: Packet)
    suspend fun getPacket(packetId: Long): Packet?
    fun getShiftWithPackets(shiftId: Long): Flow<FullShift>
}