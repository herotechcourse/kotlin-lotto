package lotto.controller

import lotto.model.LottoMachine
import lotto.model.LottoPrinter
import lotto.model.LottoTicket
import lotto.model.Numbers
import lotto.model.Tickets
import lotto.util.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

object Controller {
    val inputView = InputView
    val resultView = ResultView
    private val amountOfMoney: Int = inputView.retryable { InputView.getPurchaseAmount() }
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
        updateAmountOfManualTicket()
        val manualTickets =
            LottoPrinter.generateLottoTickets(amountOfManualTicket) {
                inputView.retryable { inputView.getLottoNumbers() }
            }
        val autoTickets =
            LottoPrinter.generateLottoTickets(amountOfAutoTicket) {
                RandomNumberGenerator.generateNumber()
            }
        printLottoTickets(manualTickets, autoTickets)
        readWinningNumbers()
        runLottoMachine()
    }

    private fun updateAmountOfManualTicket() {
        amountOfManualTicket = inputView.retryable { inputView.getNumberOfManualTickets(amountOfTicket) }
        inputView.informForManualTicketNumbers()
    }

    private fun printLottoTickets(
        manualTickets: Tickets,
        autoTickets: Tickets,
    ) {
        val tickets = Tickets().asList().toMutableList()
        tickets.addAll(manualTickets.asList())
        tickets.addAll(autoTickets.asList())
        bundleOfTicket = Tickets(tickets)
        resultView.displayNumberOfTickets(amountOfManualTicket, amountOfAutoTicket)
        resultView.displayTickets(bundleOfTicket)
    }

    private fun readWinningNumbers() {
        lastWeekWinningNumbers = inputView.retryable { inputView.getLastWeekWinningNumbers() }
        bonusNumber = inputView.retryable { InputView.getBonusNumber() }
        println()
    }

    private fun runLottoMachine() {
        val machine = LottoMachine(amountOfMoney, Numbers(lastWeekWinningNumbers), bonusNumber)
        machine.bundleOfLottoTicket = bundleOfTicket
        machine.writeResultTable()

        val winStats = machine.winStat
        winStats.calculateWinningMoney(machine.resultTable)
        winStats.calculateReturnRate(machine.amountOfMoney)

        resultView.displayWinningStatistics(machine.resultTable)
        resultView.displayReturnRate(winStats.returnRate)
    }
}
