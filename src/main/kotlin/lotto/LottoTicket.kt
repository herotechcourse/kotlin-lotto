package lotto

class LottoTicket(val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)) {
    val cost: Int = COST_OF_TICKET

    init {
        require(cost == COST_OF_TICKET) { "Cost of Ticket should be $COST_OF_TICKET" }
        require(numbers.size == SIZE_OF_NUMBERS) { "Size of numbers should be $SIZE_OF_NUMBERS" }
    }

    companion object {
        const val COST_OF_TICKET = 1000
        const val SIZE_OF_NUMBERS = 6
    }
}
