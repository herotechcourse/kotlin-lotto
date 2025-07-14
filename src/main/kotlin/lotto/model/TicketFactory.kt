package lotto.model

import lotto.view.Error

object TicketFactory {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount / 1000
    }

    fun handleTicketGeneration(
        manualTicketsList: List<Set<Int>>,
        automaticTicketsNumber: Int,
    ): List<Lotto> {
        val automaticTickets = TicketGenerator.generateAutomaticTickets(automaticTicketsNumber)
        val manualTickets = TicketGenerator.generateManualTickets(manualTicketsList)
        return automaticTickets.plus(manualTickets)
    }
}
