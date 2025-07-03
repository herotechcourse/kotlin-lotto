package lotto

fun main() {
    val amountOfMoney = InputView.getPurchaseAmount()
    val printer = LottoPrinter(amountOfMoney)

    ResultView.displayNumberOfTickets(printer.amountOfTicket)
    ResultView.displayTickets(printer.bundleOfLottoTicket)

    val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()
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
