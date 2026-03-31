package ru.kima.packetmaster.domain.shift.model

data class FullShift(
    val shift: Shift,
    val orders: List<Order>
) {
    companion object {
        fun default(
            shift: Shift = Shift.default(),
            orders: List<Order> = emptyList()
        ) = FullShift(
            shift = shift,
            orders = orders
        )
    }
}
