package lotto

// here ticket is a constructor parameter, but not a property
class Calculator(
    tickets: MutableList<Lotto>,
    private val winningNumbers: WinningNumbers,
    private var _results: MutableMap<Rank, Int> = emptyMap<Rank, Int>().toMutableMap(),
) {
    init {
        tickets.forEach {
            val count = findMatches(it, winningNumbers.winningNumbers)
            val rank =
                Rank.valueOf(
                    count,
                    bonusNumberPresent(it, winningNumbers.bonusNumber),
                )
            _results[rank] = _results.getOrDefault(rank, 0) + 1
        }
    }
    val results: Map<Rank, Int>
        get() = _results

    fun calculateReturnRate(purchaseAmount: Int): Float {
        return (calculateTotalEarnings() / purchaseAmount.toFloat())
    }

    fun calculateTotalEarnings(): Float {
        var total = 0
        _results.forEach { total += it.key.winningMoney * it.value }
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
