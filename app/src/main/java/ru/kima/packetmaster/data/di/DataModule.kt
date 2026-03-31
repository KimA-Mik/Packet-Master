package ru.kima.packetmaster.data.di

import androidx.room.Room
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import ru.kima.packetmaster.data.local.database.AppDatabase
import ru.kima.packetmaster.data.shift.ShiftRepositoryImpl
import ru.kima.packetmaster.domain.shift.repositoty.ShiftRepository

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java, AppDatabase.NAME
        ).build()
    }

    single<ShiftRepositoryImpl>() bind ShiftRepository::class
}