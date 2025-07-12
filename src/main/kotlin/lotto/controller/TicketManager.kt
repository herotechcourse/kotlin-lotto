package lotto.controller

import lotto.model.LottoPrinter
import lotto.model.LottoTicket
import lotto.model.Tickets
import lotto.util.RandomNumberGenerator

class TicketManager(amountOfMoney: Int) {
    val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    val amountOfManualTicket = callControllerToGetAmountOfManualTicket()
    val amountOfAutoTicket: Int
        get() {
            return amountOfTicket - amountOfManualTicket
        }
    val manualTickets = takeManualTickets()
    val autoTickets =
        LottoPrinter.generateLottoTickets(amountOfAutoTicket) {
            RandomNumberGenerator.generateNumber()
        }
    val tickets: Tickets = getBundleOfTicket()

    private fun takeManualTickets(): Tickets {
        Controller.inputView.informForManualTicketNumbers()
        return LottoPrinter.generateLottoTickets(amountOfManualTicket) {
            callControllerToGetLottoNumbers()
        }
    }

    private fun getBundleOfTicket(): Tickets {
        val tickets = Tickets().asList().toMutableList()
        tickets.addAll(manualTickets.asList())
        tickets.addAll(autoTickets.asList())
        return Tickets(tickets.toList())
    }

    private fun callControllerToGetAmountOfManualTicket(): Int {
        return Controller.inputView.retryable { Controller.inputView.getNumberOfManualTickets(amountOfTicket) }
    }

    private fun callControllerToGetLottoNumbers(): List<Int> {
        return Controller.inputView.retryable { Controller.inputView.getLottoNumbers() }
    }
}
