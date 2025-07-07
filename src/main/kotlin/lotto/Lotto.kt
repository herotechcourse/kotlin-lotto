package lotto

object Lotto {
    fun run() {
        val amountOfMoney = retryable { InputView.getPurchaseAmount() }
        val printer = LottoPrinter(amountOfMoney)

        ResultView.displayNumberOfTickets(printer.amountOfTicket)
        ResultView.displayTickets(printer.bundleOfLottoTicket)

        val lastWeekWinningNumbers = retryable { InputView.getLastWeekWinningNumbers() }
        val bonusNumber = retryable { InputView.getBonusNumber() }
        println()

        val machine = LottoMachine(amountOfMoney, lastWeekWinningNumbers, bonusNumber)
        machine.bundleOfLottoTicket = printer.bundleOfLottoTicket
        machine.writeResultTable()

        val winningMoney = WinStatCalculator.calculateWinningMoney(machine.resultTable)
        val returnRate = WinStatCalculator.calculateReturnRate(winningMoney, machine.amountOfMoney)

        ResultView.displayWinningStatistics(machine.resultTable)
        ResultView.displayReturnRate(returnRate)
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
