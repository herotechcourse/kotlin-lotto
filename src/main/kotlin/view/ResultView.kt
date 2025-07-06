package view

import lotto.Lotto
import lotto.Rank

object ResultView {
    fun viewTicketsAmount(ticketsAmount: Int) {
        println("You have purchased $ticketsAmount tickets")
    }

    fun viewTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.numbers.toString())
        }
    }

    fun viewWinning(result: Map<Rank, Int>) {
        println("Winning statistic")
        println("------------------")
        for (rank in Rank.entries.sortedBy { it.prizeAmount }) {
            if (rank == Rank.NONE) continue
            val bonusBall =
                when (rank) {
                    Rank.SECOND -> "+ Bonus Ball"
                    else -> ""
                }
            println("${rank.matchCount} matches $bonusBall (${rank.prizeAmount} KRW) - ${result[rank] ?: 0}  tickets")
        }
    }

    fun viewRate(rate: Double) {
        println("Total return rate is $rate (A rate below 1 means a loss)")
    }
}
