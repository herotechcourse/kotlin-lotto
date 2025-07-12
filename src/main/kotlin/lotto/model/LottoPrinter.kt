package lotto.model

object LottoPrinter {
    fun generateLottoTickets(
        amountOfTicket: Int,
        method: () -> List<Int>,
    ): Tickets {
        val tickets = Tickets().asList().toMutableList()
        repeat((1..amountOfTicket).count()) {
            val input = method()
            val numbers = Numbers(input)
            val ticket = LottoTicket(numbers)
            tickets.add(ticket)
        }
        return Tickets(tickets)
    }
}
