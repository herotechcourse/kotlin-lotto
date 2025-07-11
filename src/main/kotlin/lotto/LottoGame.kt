package lotto

class LottoGame() {
    fun play(
        playersTickets: List<Lotto>,
        winningNumbers: Lotto,
        bonusNumber: LottoNumber,
    ): List<RankResult> {
        val results: MutableList<RankResult> = mutableListOf()
        for (ticket in playersTickets) {
            val matchCount = ticket.matchCount(winningNumbers.numbers)
            val hasBonusNum = ticket.containsBonusNum(bonusNumber)
            val rank = Rank.getRank(matchCount, hasBonusNum)
            updateRankResultList(results, rank)
        }
        return results.toList()
    }

    fun countWinningAmount(results: List<RankResult>): Money {
        var amount = 0
        for (result in results) {
            amount += result.rank.prizeAmount * result.ticketsCount
        }
        return Money(amount)
    }

    private fun updateRankResultList(
        results: MutableList<RankResult>,
        rank: Rank,
    ) {
        val resultElement = results.find { it.rank == rank }
        if (resultElement != null) {
            resultElement.increaseTicketsCount()
        } else {
            results.add(RankResult(rank))
        }
    }
}
