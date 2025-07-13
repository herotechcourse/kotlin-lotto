package lotto

class Purchase(val amount: Money) {
    val change: Money
    val ticketCount: Int
    init {
        require(amount.value in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
        change = Money(amount.value % TICKET_PRICE)
        ticketCount = amount.value / TICKET_PRICE
    }

    fun calculateAutomaticTicketsCount(manualTicketsCount: Int): Int {
        return ticketCount - manualTicketsCount
    }

    fun checkManualTicketsCount(count: Int) {
        require(count in 0..ticketCount) {
            "Number of manual tickets cannot exceed $ticketCount."
        }
    }

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        internal const val TICKET_PRICE = 1_000
    }
}