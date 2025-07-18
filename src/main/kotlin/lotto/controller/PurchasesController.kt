package lotto.controller

import lotto.dto.PurchaseResult
import lotto.dto.UserPurchase

object PurchasesController {
    fun getPurchaseResult(): PurchaseResult {
        val userPurchase = getUserPurchases()
        val totalTickets =
            TicketIssuer.issueManual(userPurchase.manualTicketsCount) +
                TicketIssuer.issueRandom(userPurchase.randomTicketsCount)
        return PurchaseResult(userPurchase, totalTickets)
    }

    private fun getUserPurchases(): UserPurchase {
        val amount = Prompter.askAmount()
        val manualTicketsCount = Prompter.askManualTicketsNumbers(amount)
        return UserPurchase(amount, manualTicketsCount)
    }
}
