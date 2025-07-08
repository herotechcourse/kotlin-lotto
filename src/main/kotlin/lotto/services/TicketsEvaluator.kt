package lotto.services

import lotto.domain.Rank
import lotto.domain.WinningCombination
import lotto.dto.IssuedTickets

object TicketsEvaluator {
    fun runWith(issuedTickets: IssuedTickets, winningCombination: WinningCombination): List<Rank> {
        return issuedTickets.get().map {
            it.getRank(winningCombination)
        }
    }

    fun getTotalRate(ranks: List<Rank>, totalAmount: Int): Double {
        val totalPrize = ranks.sumOf { it.winningMoney }
        return if (totalPrize == 0) 0.0 else (totalPrize.toDouble() / totalAmount) * 100.0
    }
}