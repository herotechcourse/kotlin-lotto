package lotto

class LottoMachine(
    val amountOfMoney: Int,
    val lastWeekWinningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    val bundleOfLottoTicket: List<LottoTicket> = generateLottoTickets(amountOfTicket)

    fun generateLottoTickets(amountOfTicket: Int): List<LottoTicket> {
        val tempList = mutableListOf<LottoTicket>()
        (1..amountOfTicket).forEach { it
            val ticket = LottoTicket(RandomNumberGenerator.generateNumber())
            tempList.add(ticket)
        }
        return tempList
    }

}