package lotto

import view.InputView

class LottoMachine(val ticketsNumber: PurchasedTicketsNumber) {
    val tickets: List<Lotto> = issueTickets()

    fun issueTickets(): List<Lotto> {
        val tickets = mutableListOf<Lotto>()

        tickets.addAll(
            (1..ticketsNumber.getManuelTicketsNumber()).map {
                Lotto(manuelInputNumbers())
            },
        )

        tickets.addAll(
            (ticketsNumber.getManuelTicketsNumber() + 1..ticketsNumber.getTotalTicketsCount()).map {
                Lotto(generateRandomNumber())
            },
        )

        return tickets.toList()
    }

    private fun generateRandomNumber(): List<Int> {
        return (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER).shuffled().take(6)
    }

    private fun manuelInputNumbers(): List<Int> = InputView.getNumbersForTicket()
}
