package lotto.controller

import lotto.model.LottoMachine
import lotto.model.LottoPrinter
import lotto.model.LottoTicket
import lotto.model.Numbers
import lotto.model.Tickets
import lotto.view.InputView
import lotto.view.ResultView

class Controller {
    private val amountOfMoney: Int = retryable { InputView.getPurchaseAmount() }
    private val amountOfTicket: Int = amountOfMoney / LottoTicket.COST_OF_TICKET
    private var amountOfManualTicket = 0
    private val amountOfAutoTicket: Int
        get() {
            return amountOfTicket - amountOfManualTicket
        }
    private var bundleOfTicket: Tickets = Tickets(emptyList())
    private var lastWeekWinningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun run() {
        val manualTickets = buyManualLottoTickets()
        printLottoTickets(manualTickets)
        readWinningNumbers()
        runLottoMachine()
    }

    private fun buyManualLottoTickets(): Tickets {
        amountOfManualTicket = retryable { InputView.getNumberOfManualTickets(amountOfTicket) }
        InputView.informForManualTicketNumbers()
        val manualTickets = Tickets().asList().toMutableList()
        repeat((1..amountOfManualTicket).count()) {
            val input = retryable { InputView.getLottoNumbers() }
            val numbers = Numbers(input)
            val ticket = LottoTicket(numbers)
            manualTickets.add(ticket)
        }
        return Tickets(manualTickets)
    }

    private fun printLottoTickets(manualTickets: Tickets) {
        val printer = LottoPrinter(amountOfAutoTicket)
        val tickets = Tickets().asList().toMutableList()
        tickets.addAll(manualTickets.asList())
        tickets.addAll(printer.bundleOfLottoTicket.asList())
        bundleOfTicket = Tickets(tickets)
        ResultView.displayNumberOfTickets(amountOfManualTicket, amountOfAutoTicket)
        ResultView.displayTickets(bundleOfTicket)
    }

    private fun readWinningNumbers() {
        lastWeekWinningNumbers = retryable { InputView.getLastWeekWinningNumbers() }
        bonusNumber = retryable { InputView.getBonusNumber() }
        println()
    }

    private fun runLottoMachine() {
        val machine = LottoMachine(amountOfMoney, Numbers(lastWeekWinningNumbers), bonusNumber)
        machine.bundleOfLottoTicket = bundleOfTicket
        machine.writeResultTable()

        val winStats = machine.winStat
        winStats.calculateWinningMoney(machine.resultTable)
        winStats.calculateReturnRate(machine.amountOfMoney)

        ResultView.displayWinningStatistics(machine.resultTable)
        ResultView.displayReturnRate(winStats.returnRate)
    }

    private fun <T> retryable(inputMethod: () -> T): T {
        while (true) {
            try {
                return inputMethod()
            } catch (err: IllegalArgumentException) {
                println("${err.message}")
            }
        }
    }
}
