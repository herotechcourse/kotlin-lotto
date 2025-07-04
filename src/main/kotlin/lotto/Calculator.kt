package lotto

class Calculator(
    tickets: MutableList<Lotto>,
    val winningNumbers: WinningNumbers,
    var results: MutableMap<Rank, Int> = emptyMap<Rank, Int>().toMutableMap(),
) {
    init {
        tickets.forEach {
            val count = findMatches(it, winningNumbers.winningNumbers)
            val rank =
                Rank.valueOf(
                    count,
                    bonusNumberPresent(it, winningNumbers.bonusNumber),
                )
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
    }

    fun calculateReturnRate(purchaseAmount: Int): Float {
        return (calculateTotalEarnings() / purchaseAmount.toFloat())
    }

    fun calculateTotalEarnings(): Float {
        var total = 0
        results.forEach { total += it.key.winningMoney * it.value }
        return total.toFloat()
    }

    private fun findMatches(
        ticket: Lotto,
        winningTicket: Lotto,
    ): Int {
        var count = 0
        ticket.numbers.forEach { count += if (winningTicket.numbers.contains(it)) 1 else 0 }
        return count
    }

    private fun bonusNumberPresent(
        ticket: Lotto,
        bonusNumber: Int,
    ): Boolean {
        return ticket.numbers.contains(bonusNumber)
    }
}
