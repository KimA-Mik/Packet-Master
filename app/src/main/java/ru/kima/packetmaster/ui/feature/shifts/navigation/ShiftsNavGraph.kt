package ru.kima.packetmaster.ui.feature.shifts.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

fun EntryProviderScope<NavKey>.shiftsGraph() {
    entry<ShiftsGraph.List> {

    }

    entry<ShiftsGraph.List.Details> { details ->

    }
}