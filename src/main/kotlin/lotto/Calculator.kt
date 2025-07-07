package lotto

// here ticket is a constructor parameter, but not a property
class Calculator(
    tickets: List<Lotto>,
    purchaseAmount: Int,
    private val winningNumbers: WinningNumbers,
) {
    val results: Map<Rank, Int> = calculateResults(tickets)
    val totalEarnings: Int = results.entries.sumOf{ it.key.winningMoney * it.value }
    val returnRate: Float = (totalEarnings.toFloat() / purchaseAmount.toFloat())

    fun calculateResults(tickets: List<Lotto>): Map<Rank, Int> {
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
        return table
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
