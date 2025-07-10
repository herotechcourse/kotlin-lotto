package lotto.model

import lotto.util.RandomNumberGenerator

class LottoPrinter(amountOfAutoTicket: Int) {
    val bundleOfLottoTicket: Tickets = generateLottoTickets(amountOfAutoTicket)

    private fun generateLottoTickets(amountOfTicket: Int): Tickets {
        val tickets = Tickets().asList().toMutableList()
        repeat((1..amountOfTicket).count()) {
            val numbers = Numbers(RandomNumberGenerator.generateNumber())
            val ticket = LottoTicket(numbers)
            tickets.add(ticket)
        }
        return Tickets(tickets)
    }
}
