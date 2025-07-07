package lotto.dto

import lotto.controller.TicketIssuer

data class PurchaseResult(
    val userPurchase: UserPurchase,
) {
    val manualTickets = TicketIssuer.issueManual(userPurchase.manualTicketsCount)
    val randomTickets = TicketIssuer.issueRandom(userPurchase.randomTicketsCount)
    val totalTickets = manualTickets + randomTickets
}
