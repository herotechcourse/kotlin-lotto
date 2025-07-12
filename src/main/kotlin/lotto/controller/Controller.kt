package lotto.controller

import lotto.model.LottoMachine
import lotto.model.Numbers
import lotto.view.InputView
import lotto.view.ResultView

object Controller {
    val inputView = InputView
    val resultView = ResultView
    private val amountOfMoney: Int = inputView.retryable { InputView.getPurchaseAmount() }
    private val ticketManager = TicketManager(amountOfMoney)
    private var lastWeekWinningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun run() {
        printLottoTickets()
        readWinningNumbers()
        runLottoMachine()
    }

    private fun printLottoTickets() {
        resultView.displayNumberOfTickets(ticketManager.amountOfManualTicket, ticketManager.amountOfAutoTicket)
        resultView.displayTickets(ticketManager.tickets)
    }

    private fun readWinningNumbers() {
        lastWeekWinningNumbers = inputView.retryable { inputView.getLastWeekWinningNumbers() }
        bonusNumber = inputView.retryable { InputView.getBonusNumber() }
        println()
    }

    private fun runLottoMachine() {
        val machine = LottoMachine(amountOfMoney, Numbers(lastWeekWinningNumbers), bonusNumber)
        machine.bundleOfLottoTicket = ticketManager.tickets
        machine.writeResultTable()

        val winStats = machine.winStat
        winStats.calculateWinningMoney(machine.resultTable)
        winStats.calculateReturnRate(machine.amountOfMoney)

        resultView.displayWinningStatistics(machine.resultTable)
        resultView.displayReturnRate(winStats.returnRate)
    }
}
