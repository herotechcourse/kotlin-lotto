package view

import lotto.Calculator
import lotto.Lotto
import lotto.Rank

object ResultView {
    fun viewTicketsAmount(ticketsAmount: Int) {
        println("You have purchased $ticketsAmount tickets")
    }

    fun viewTickets(
        tickets: List<Lotto>,
        manuelTicketsNumber: Int,
        automaticTicketsNumber: Int,
    ) {
        println("Purchased $manuelTicketsNumber manual and $automaticTicketsNumber automatic tickets.")
        tickets.forEach {
            println(it.numbers.numbers.toString())
        }
    }

    fun viewWinning(resul: MutableMap<Rank, Int>) {
        println("Winning statistic")
        println("------------------")
        for (rank in Rank.entries.sortedBy { it.prizeAmount }) {
            if (rank == Rank.NONE) continue
            val bonusBall =
                when (rank) {
                    Rank.SECOND -> "+ Bonus Ball"
                    else -> ""
                }
            println("${rank.matchCount} matches $bonusBall (${rank.prizeAmount} KRW) - ${resul[rank] ?: 0}  tickets")
        }
    }

    fun viewRate(
        winningAmount: Int,
        purchaseAmount: Int,
    ) {
        val rate = Calculator.division(winningAmount, purchaseAmount)
        val roundedRate = String.format("%.2f", rate)
        println("Total return rate is $roundedRate (A rate below 1 means a loss)")
    }
}
