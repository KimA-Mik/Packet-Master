package ru.kima.packetmaster.data.shift

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.kima.packetmaster.data.local.database.AppDatabase
import ru.kima.packetmaster.data.shift.mappers.toEntity
import ru.kima.packetmaster.data.shift.mappers.toFullShift
import ru.kima.packetmaster.data.shift.mappers.toPacket
import ru.kima.packetmaster.data.shift.mappers.toShift
import ru.kima.packetmaster.domain.shift.model.FullShift
import ru.kima.packetmaster.domain.shift.model.Packet
import ru.kima.packetmaster.domain.shift.model.Shift
import ru.kima.packetmaster.domain.shift.repositoty.ShiftRepository

class ShiftRepositoryImpl(
    database: AppDatabase
) : ShiftRepository {
    private val dao = database.shiftDao()
    override suspend fun insertShift(shift: Shift): Long {
        return dao.insertShift(shift.toEntity())
    }

    override suspend fun updateShift(shift: Shift) {
        dao.updateShift(shift.toEntity())
    }

    override suspend fun deleteShift(shift: Shift) {
        dao.deleteShift(shift.toEntity())
    }

    override fun getShifts(): Flow<List<Shift>> {
        return dao.getShifts().map { list -> list.map { it.toShift() } }
    }

    override suspend fun insertPacket(packet: Packet): Long {
        return dao.insertPacket(packet.toEntity())
    }

    override suspend fun updatePacket(packet: Packet) {
        dao.updatePacket(packet.toEntity())
    }

    override suspend fun deletePacket(packet: Packet) {
        dao.deletePacket(packet.toEntity())
    }

    override suspend fun getPacket(packetId: Long): Packet? {
        return dao.getPacket(packetId)?.toPacket()
    }

    override fun getShiftWithPackets(shiftId: Long): Flow<FullShift> {
        return dao.getShiftWithPackets(shiftId).map { it.toFullShift() }
    }
}