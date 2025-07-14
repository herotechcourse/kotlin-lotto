package lotto.model

object WinningLogic {
    fun determineWinningTickets(
        tickets: List<Lotto>,
        winningLotto: WinningLotto,
    ): LottoResult {
        val mapOfRanks =
            tickets.map {
                val countMatches = winningLotto.countMatches(it)
                val hasBonus = winningLotto.isBonusMatched(it)
                Rank.valueOf(countMatches, hasBonus)
            }.groupingBy { it }
                .eachCount()

        return LottoResult(result = mapOfRanks, ticketsCount = tickets.size)
    }
}
