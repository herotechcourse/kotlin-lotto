package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.toString()) }
    }

    fun displayCombinedTickets(tickets: List<Lotto>, manualCount: Int, automaticCount: Int) {
        println("\nYou have purchased $manualCount manual and $automaticCount automatic tickets.")
        tickets.forEach {
                println(it.sortedNumbers.joinToString(prefix = "[", postfix = "]"))
        }
    }

    fun displayChange(change: Money) {
        println("\nYour change is ${change.value} KRW.")
    }

    fun displayTotalWinningAmount(totalAmount: Money) {
        println("Total earnings: %,d KRW.".format(totalAmount.value))
    }

    private fun Map<Rank, Int>.count(rank: Rank) = getOrDefault(rank, 0)

    private fun buildWinningsString(results: Map<Rank, Int>): String {
        val string = buildString {
            appendLine("\nWinning Statistics")
            appendLine("------------------")
            Rank.entries
                .filter { it != Rank.MISS }
                .reversed()
                .forEach {
                    val count = results.count(it)
                    append("${it.countOfMatch} Matches")
                    if (it == Rank.SECOND)
                        append(" + Bonus Ball")
                    appendLine(" (%,d KRW) - $count tickets".format(it.winningMoney))
                }
        }
        return string
    }

    fun displayWinnings(results: Map<Rank, Int>) {
        val string = buildWinningsString(results)
        println(string)
    }

    fun displayReturnRate(returnRate: Float) {
        println("Total return rate is %,.2f%% (A rate below 1 means a loss).".format(returnRate * 100))
    }
}
