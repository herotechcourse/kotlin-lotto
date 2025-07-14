package lotto.dto

import lotto.controller.TicketIssuer

data class PurchaseResult(
    val userPurchase: UserPurchase,
) {
    val totalTickets =
        TicketIssuer.issueManual(userPurchase.manualTicketsCount) +
            TicketIssuer.issueRandom(userPurchase.randomTicketsCount)
}
