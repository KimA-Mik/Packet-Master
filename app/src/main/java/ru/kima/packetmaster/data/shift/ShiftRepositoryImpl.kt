package ru.kima.packetmaster.data.shift

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.kima.packetmaster.data.local.database.AppDatabase
import ru.kima.packetmaster.data.shift.mappers.toEntity
import ru.kima.packetmaster.data.shift.mappers.toFullShift
import ru.kima.packetmaster.data.shift.mappers.toPacket
import ru.kima.packetmaster.data.shift.mappers.toShift
import ru.kima.packetmaster.domain.shift.model.FullShift
import ru.kima.packetmaster.domain.shift.model.Order
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

    override suspend fun insertPacket(order: Order): Long {
        return dao.insertPacket(order.toEntity())
    }

    override suspend fun updatePacket(order: Order) {
        dao.updatePacket(order.toEntity())
    }

    override suspend fun deletePacket(order: Order) {
        dao.deletePacket(order.toEntity())
    }

    override suspend fun getPacket(packetId: Long): Order? {
        return dao.getPacket(packetId)?.toPacket()
    }

    override fun getShiftWithPackets(shiftId: Long): Flow<FullShift> {
        return dao.getShiftWithPackets(shiftId).map { it.toFullShift() }
    }
}