package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.numbers.sorted().joinToString(prefix = "[", postfix = "]")) }
        println()
    }

    fun displayChange(change: Int) {
        println("Your change is $change KRW.")
        println()
    }

    fun displayTotalWinningAmount(totalAmount: Float) {
        println("Total Earnings %,.2f KRW.".format(totalAmount))
    }

    fun displayWinnings(results: Map<Rank, Int>) {
        println("Winning Statistics\n------------------")
        Rank.entries.reversed().forEach {
            if (it == Rank.MISS) {
                return@forEach
            }
            val count = results.getOrDefault(it, 0)
            if (it == Rank.SECOND) {
                displaySecondRank(it, count)
            } else {
                println("${it.countOfMatch} Matches (${String.format("%,d", it.winningMoney)} KRW) - $count tickets")
            }
        }
        println()
    }

    fun displayReturnRate(returnRate: Float) {
        println("Total return rate is $returnRate% (A rate below 1 means a loss).")
    }

    private fun displaySecondRank(
        rank: Rank,
        count: Int,
    ) {
        val winningMoney = String.format("%,d", rank.winningMoney)
        println("${rank.countOfMatch} Matches + Bonus Ball ($winningMoney KRW) - $count tickets")
    }
}
