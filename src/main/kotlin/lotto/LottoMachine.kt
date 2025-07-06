package lotto

class LottoMachine(
    val amountOfMoney: Int,
    val lastWeekWinningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    var bundleOfLottoTicket: List<LottoTicket> = emptyList()
    val resultTable: MutableList<Int> = MutableList(6) { 0 }

    // TODO: might have to update resultTable before initiating winStat
    val winStat: WinningStatistics = WinningStatistics()

    fun writeResultTable() {
        bundleOfLottoTicket.forEach { filterTicket(it) }
    }

    fun filterTicket(ticket: LottoTicket) {
        when (getRankOfTicket(ticket)) {
            Rank.FIRST -> resultTable[1]++
            Rank.SECOND -> resultTable[2]++
            Rank.THIRD -> resultTable[3]++
            Rank.FOURTH -> resultTable[4]++
            Rank.FIFTH -> resultTable[5]++
            Rank.MISS -> resultTable[0]++
        }
    }

    private fun getRankOfTicket(ticket: LottoTicket): Rank {
        val count = ticket.numbers.count { lastWeekWinningNumbers.contains(it) }
        val hasBonusNumber = ticket.numbers.contains(bonusNumber)
        return Rank.of(count, hasBonusNumber)
    }
}
