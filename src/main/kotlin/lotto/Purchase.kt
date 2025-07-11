package lotto

class Purchase(val amount: Int) {
    init {
        require(amount in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
    }

    val change = amount % TICKET_PRICE
    val ticketCount = amount / TICKET_PRICE
    var manualTicketsCount: Int = 0
        set(value) {
            require(value in 0..ticketCount) { "Number of manual tickets cannot exceed $ticketCount." }
            field = value
        }
    val automaticTicketsCount: Int
        get() = ticketCount - manualTicketsCount

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        internal const val TICKET_PRICE = 1_000
    }
}