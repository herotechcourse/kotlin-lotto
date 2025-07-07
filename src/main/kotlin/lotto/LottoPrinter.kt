package lotto

class LottoPrinter(val amountOfMoney: Int) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    val bundleOfLottoTicket: List<LottoTicket> = generateLottoTickets(amountOfTicket)

    fun generateLottoTickets(amountOfTicket: Int): List<LottoTicket> {
        return List(amountOfTicket) {
            LottoTicket(RandomNumberGenerator.generateNumber())
        }
    }
}
