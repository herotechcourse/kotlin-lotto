package lotto

class LottoMachine(
    val amountOfMoney: Int,
    val lastWeekWinningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    lateinit var bundleOfLottoTicket: List<LottoTicket>
    val resultTable: MutableMap<Rank, Int> = mutableMapOf()

    fun writeResultTable() {
        bundleOfLottoTicket.forEach { filterTicket(it) }
    }

    fun filterTicket(ticket: LottoTicket) {
        val rank = Rank.ofTicket(ticket, lastWeekWinningNumbers, bonusNumber)
        resultTable[rank] = resultTable.getOrDefault(rank, 0) + 1
    }
}
