package lotto

class Statistics(
    private val winningNumbers: WinningNumbers,
) {
    fun calculateTotalEarnings(results: Result): Money {
        val earnings = results
            .value
            .entries
            .sumOf { it.key.winningMoney * it.value }
        return Money(earnings)
    }

    fun calculateReturnRate(totalEarnings: Money, purchaseAmount: Money): Float {
        return (totalEarnings.value.toFloat() / purchaseAmount.value.toFloat())
    }

    fun calculateResults(tickets: List<Lotto>): Result {
        val table = mutableMapOf<Rank, Int>()
        tickets.forEach {
            val count = findMatches(it, winningNumbers.winningNumbers)
            val rank =
                Rank.valueOf(
                    count,
                    it.hasBonusNumber(winningNumbers.bonusNumber),
                )
            table[rank] = table.getOrDefault(rank, 0) + 1
        }
        return Result(table)
    }

    private fun findMatches(
        ticket: Lotto,
        winningTicket: Lotto,
    ): Int {
        var count = 0
        ticket.numbers.forEach { count += if (winningTicket.numbers.contains(it)) 1 else 0 }
        return count
    }
}
