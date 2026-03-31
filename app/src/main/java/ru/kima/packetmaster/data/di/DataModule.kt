package ru.kima.packetmaster.data.di

import androidx.room.Room
import org.koin.dsl.module
import ru.kima.packetmaster.data.local.database.AppDatabase

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java, AppDatabase.NAME
        ).build()
    }
}