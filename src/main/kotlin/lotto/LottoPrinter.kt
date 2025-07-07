package lotto

object LottoPrinter {
    fun generateLottoTickets(amount: Int): List<LottoTicket> {
        return List(amount) {
            LottoTicket(RandomNumberGenerator.generateNumber())
        }
    }
}
