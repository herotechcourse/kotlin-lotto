package lotto

class LottoMachine(
    val amountOfMoney: Int,
    val lastWeekWinningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    val bundleOfLottoTicket: List<LottoTicket> = generateLottoTickets(amountOfTicket)
    val resultTable: MutableList<Int> = MutableList(6) { 0 }

    // TODO: might have to update resultTable before initiating winStat
    val winStat: WinningStatistics = WinningStatistics()

    fun generateLottoTickets(amountOfTicket: Int): List<LottoTicket> {
        val tempList = mutableListOf<LottoTicket>()
        (1..amountOfTicket).forEach {
            it
            val ticket = LottoTicket(RandomNumberGenerator.generateNumber())
            tempList.add(ticket)
        }
        return tempList
    }

    fun writeResultTable() {
        bundleOfLottoTicket.forEach { ticket ->
            when (getRankOfTicket(ticket)) {
                Rank.FIRST -> resultTable[1]++
                Rank.SECOND -> resultTable[2]++
                Rank.THIRD -> resultTable[3]++
                Rank.FOURTH -> resultTable[4]++
                Rank.FIFTH -> resultTable[5]++
                Rank.MISS -> resultTable[0]++
            }
        }
    }

    private fun getRankOfTicket(ticket: LottoTicket): Rank {
        val count = ticket.numbers.count { lastWeekWinningNumbers.contains(it) }
        val hasBonusNumber = ticket.numbers.contains(bonusNumber)
        return Rank.of(count, hasBonusNumber)
    }
}
