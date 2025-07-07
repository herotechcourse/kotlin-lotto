package lotto

class PurchasedTicketsNumber(private val manuelTicketsNumber: Int, purchasedAmount: Money) {
    private val totalTickets = purchasedAmount.getValue() / TICKET_PRICE

    init {
        require(manuelTicketsNumber >= MINIMUM_NUMBER && manuelTicketsNumber <= totalTickets) {
            "Number of manuel tickets should be in range $MINIMUM_NUMBER to $totalTickets"
        }
    }

    fun getTotalTicketsCount(): Int = totalTickets

    fun getManuelTicketsNumber(): Int = manuelTicketsNumber

    private companion object {
        private const val MINIMUM_NUMBER = 0
    }
}
