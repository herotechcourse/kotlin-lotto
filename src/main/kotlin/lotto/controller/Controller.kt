package lotto.controller

import lotto.model.LottoMachine
import lotto.model.LottoPrinter
import lotto.model.LottoTicket
import lotto.model.Numbers
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
    private var bundleOfTicket: List<LottoTicket> = emptyList()
    private var lastWeekWinningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun run() {
        val manualTickets = buyManualLottoTickets()
        printLottoTickets(manualTickets)
        readWinningNumbers()
        runLottoMachine()
    }

    private fun buyManualLottoTickets(): List<LottoTicket> {
        amountOfManualTicket = retryable { InputView.getNumberOfManualTickets(amountOfTicket) }
        InputView.informForManualTicketNumbers()
        val manualTickets = mutableListOf<LottoTicket>()
        repeat((1..amountOfManualTicket).count()) {
            val input = retryable { InputView.getLottoNumbers() }
            val numbers = Numbers(input)
            val ticket = LottoTicket(numbers)
            manualTickets.add(ticket)
        }
        return manualTickets
    }

    private fun printLottoTickets(manualTickets: List<LottoTicket>) {
        val printer = LottoPrinter(amountOfAutoTicket)
        val tickets = mutableListOf<LottoTicket>()
        tickets.addAll(manualTickets)
        tickets.addAll(printer.bundleOfLottoTicket)
        bundleOfTicket = tickets
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
