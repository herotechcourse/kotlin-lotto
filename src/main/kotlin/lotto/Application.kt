package lotto

fun main() {
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
