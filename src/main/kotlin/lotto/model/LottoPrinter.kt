package lotto.model

import lotto.util.RandomNumberGenerator

class LottoPrinter(amountOfMoney: Int) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    val bundleOfLottoTicket: List<LottoTicket> = generateLottoTickets(amountOfTicket)

    private fun generateLottoTickets(amountOfTicket: Int): List<LottoTicket> {
        val tickets = mutableListOf<LottoTicket>()
        repeat((1..amountOfTicket).count()) {
            val numbers = Numbers(RandomNumberGenerator.generateNumber())
            val ticket = LottoTicket(numbers)
            tickets.add(ticket)
        }
        return tickets
    }
}
