package lotto.model

import lotto.controller.Controller
import lotto.util.RandomNumberGenerator

object LottoPrinter {
    fun generateAutoLottoTickets(amountOfTicket: Int): Tickets {
        val tickets = Tickets().asList().toMutableList()
        repeat((1..amountOfTicket).count()) {
            val numbers = Numbers(RandomNumberGenerator.generateNumber())
            val ticket = LottoTicket(numbers)
            tickets.add(ticket)
        }
        return Tickets(tickets)
    }

    fun generateManualLottoTicket(amountOfTicket: Int): Tickets {
        val tickets = Tickets().asList().toMutableList()
        repeat((1..amountOfTicket).count()) {
            val input = callControllerToGetLottoNumbers()
            val numbers = Numbers(input)
            val ticket = LottoTicket(numbers)
            tickets.add(ticket)
        }
        return Tickets(tickets)
    }

    private fun callControllerToGetLottoNumbers(): List<Int> {
        return Controller.inputView.retryable { Controller.inputView.getLottoNumbers() }
    }
}
