package lotto

class LottoMachine(
    private val lastWeekWinningNumbers: List<Int>,
    private val bonusNumber: Int,
) {
    fun createResultTable(tickets: List<LottoTicket>): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        tickets.forEach { ticket ->
            val rank = Rank.ofTicket(ticket, lastWeekWinningNumbers, bonusNumber)
            result[rank] = result.getOrDefault(rank, 0) + 1
        }
        return result
    }
}
