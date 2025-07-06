package lotto

class LottoGame() {
    fun play(
        playersTickets: List<Lotto>,
        winningNumbers: Lotto,
        bonusNumber: Int,
    ): Map<Rank, Int> {
        val results: MutableMap<Rank, Int> = mutableMapOf()
        for (ticket in playersTickets) {
            val matchCount = ticket.matchCount(winningNumbers.numbers)
            val hasBonusNum = ticket.containsBonusNum(bonusNumber)
            val rank = Rank.getRank(matchCount, hasBonusNum)
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
        return results.toMap()
    }

    fun countWinningAmount(results: Map<Rank, Int>): Int {
        var amount = 0
        for ((rank, ticketCount) in results) {
            amount += rank.prizeAmount * ticketCount
        }
        return amount
    }
}
