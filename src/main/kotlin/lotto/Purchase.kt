package lotto

@JvmInline
value class Purchase(val amount: Money) {
    init {
        require(amount.value in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
    }

    fun calculateChange(): Money = Money(amount.value % TICKET_PRICE)

    fun calculateTicketCount(): Int = amount.value / TICKET_PRICE

    fun calculateAutomaticTicketsCount(manualTicketsCount: Int): Int {
        return calculateTicketCount() - manualTicketsCount
    }

    fun checkManualTicketsCount(count: Int) {
        val ticketCount = calculateTicketCount()
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