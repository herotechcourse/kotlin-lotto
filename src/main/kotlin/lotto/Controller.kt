package lotto

import lotto.model.LottoMachine
import lotto.model.LottoPrinter
import lotto.model.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class Controller {
    var amountOfMoney: Int = 0
    var bundleOfTicket: List<LottoTicket> = emptyList()
    var lastWeekWinningNumbers: List<Int> = emptyList()
    var bonusNumber: Int = 0

    fun run() {
        buyLottoTickets()
        readWinningNumbers()
        runLottoMachine()
    }

    fun buyLottoTickets() {
        amountOfMoney = retryable { InputView.getPurchaseAmount() }
        val printer = LottoPrinter(amountOfMoney)
        bundleOfTicket = printer.bundleOfLottoTicket

        ResultView.displayNumberOfTickets(printer.amountOfTicket)
        ResultView.displayTickets(printer.bundleOfLottoTicket)
    }

    fun readWinningNumbers() {
        lastWeekWinningNumbers = retryable { InputView.getLastWeekWinningNumbers() }
        bonusNumber = retryable { InputView.getBonusNumber() }
        println()
    }

    fun runLottoMachine() {
        val machine = LottoMachine(amountOfMoney, lastWeekWinningNumbers, bonusNumber)
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
