package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Rank

object ResultView {
    fun displayTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.lottoNumbers.joinToString(",", prefix = "[", postfix = "]"))
        }
    }

    fun displayWinningStatistics(lottoResult: LottoResult) {
        displayWinningRanks(lottoResult)
        displayWinningRate(lottoResult.calculateProfitRate())
    }

    fun displayWinningRanks(lottoResult: LottoResult) {
        println()
        println("Winning Statistics")
        println("-----------------------")
        val rankList = listOf<Rank>(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)

        rankList.forEach { prize ->
            val count = lottoResult.count(prize)
            println("${prize.countOfMatch} Matches (${prize.winningMoney}) – $count tickets")
        }
    }

    fun displayWinningRate(rate: Double) {
        println("Total return rate is " + String.format("%.2f", rate) + " (A rate below 1 means a loss)")
    }

    fun displayNumberOfTicketsInput(
        manualTicketsNumber: Int,
        automaticTicketsNumber: Int,
    ) {
        println()
        println("Purchased $manualTicketsNumber manual and $automaticTicketsNumber automatic tickets.")
    }
}
