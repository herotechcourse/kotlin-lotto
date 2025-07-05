package lotto

// here ticket is a constructor parameter, but not a property
class Calculator(
    tickets: List<Lotto>,
    private val winningNumbers: WinningNumbers,
    private var _results: MutableMap<Rank, Int> = emptyMap<Rank, Int>().toMutableMap(),
) {
    init {
        calculateResults(tickets)
    }
    val results: Map<Rank, Int>
        get() = _results

    fun calculateResults(tickets: List<Lotto>) {
        tickets.forEach {
            val count = findMatches(it, winningNumbers.winningNumbers)
            val rank =
                Rank.valueOf(
                    count,
                    it.hasBonusNumber(winningNumbers.bonusNumber),
                )
            _results[rank] = _results.getOrDefault(rank, 0) + 1
        }
    }

    fun calculateReturnRate(purchaseAmount: Int): Float {
        return (calculateTotalEarnings() / purchaseAmount.toFloat())
    }

    fun calculateTotalEarnings(): Float {
        return _results.entries.sumOf{ it.key.winningMoney * it.value }.toFloat()
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
