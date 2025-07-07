package lotto

data class Purchase(val amount: Int) {
    init {
        require(amount in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
    }

    val change = amount % TICKET_PRICE
    val ticketCount = amount / TICKET_PRICE

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        private const val TICKET_PRICE = 1_000
    }
}