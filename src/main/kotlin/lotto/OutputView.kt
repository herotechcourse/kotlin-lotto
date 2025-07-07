package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.numbers.joinToString(prefix = "[", postfix = "]")) }
        println()
    }

    fun displayChange(change: Int) {
        println("Your change is $change KRW.")
        println()
    }

    fun displayTotalWinningAmount(totalAmount: Float) {
        println("Total earnings: %,d KRW.".format(totalAmount.toInt()))
    }

    private fun Map<Rank, Int>.count(rank: Rank) = getOrDefault(rank, 0)

    private fun buildWinningsString(results: Map<Rank, Int>): String {
        val string = buildString {
            appendLine("Winning Statistics")
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
