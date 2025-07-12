package lotto

class LottoMachine(
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: BonusNumber,
) {
    fun createResultTable(tickets: List<LottoTicket>): WinningStatistics {
        val result = mutableMapOf<Rank, Int>()
        tickets.forEach { ticket ->
            val rank = Rank.ofTicket(ticket, winningNumbers.numbers, bonusNumber.value)
            result[rank] = result.getOrDefault(rank, 0) + 1
        }
        return WinningStatistics(result)
    }
}
