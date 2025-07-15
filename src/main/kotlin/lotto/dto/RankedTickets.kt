package lotto.dto

import lotto.controller.TicketsEvaluator
import lotto.domain.WinningCombination

data class RankedTickets(val purchaseResult: PurchaseResult, val winningCombination: WinningCombination) {
    val ranked = TicketsEvaluator.runWith(purchaseResult.totalTickets, winningCombination)
    val totalRate = calculateTotalRate()

    private fun calculateTotalRate(): Double {
        val totalPrize = ranked.sumOf { it.winningMoney }
        val totalSpent = purchaseResult.userPurchase.amount
        return (totalPrize / totalSpent).toDouble()
    }
}
