package lotto

object ResultView {
    fun displayNumberOfTickets(numberOfTickets: Int) {
        println("$numberOfTickets tickets were purchased.")
    }

    fun displayTickets(bundleOfLottoTicket: List<LottoTicket>) {
        bundleOfLottoTicket.forEach {
            println(it.numbers.sorted())
        }
    }

    fun displayWinningStatistics(resultTable: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("------------------")
        Rank.entries
            .filter { it != Rank.MISS }
            .forEach { rank ->
                val count = resultTable[rank] ?: 0
                println("${rank.matchCount} numbers matched${if (rank.hasBonus) " + bonus ball" else ""} (${rank.prize}₩) - $count times")
            }
    }

    fun displayReturnRate(returnRate: Double) {
        println("The total rate of return is ${"%.1f".format(returnRate)}%.")
    }
}
