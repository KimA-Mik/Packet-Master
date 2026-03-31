package ru.kima.packetmaster.ui.di

import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel
import ru.kima.packetmaster.ui.feature.shifts.list.ShiftListViewModel

val uiModule = module {
    viewModel<ShiftListViewModel>()
}