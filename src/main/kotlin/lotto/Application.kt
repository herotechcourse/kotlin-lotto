package lotto

fun main() {
    val amountOfMoney = InputView.getPurchaseAmount()
    val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()
    println()

    val machine = LottoMachine(amountOfMoney, lastWeekWinningNumbers, bonusNumber)

    ResultView.displayNumberOfTickets(machine.amountOfTicket)
    ResultView.displayTickets(machine.bundleOfLottoTicket)

    machine.writeResultTable()

    val winStats = machine.winStat
    winStats.calculateWinningMoney(machine.resultTable)
    winStats.calculateReturnRate(machine.amountOfMoney)

    ResultView.displayWinningStatistics(machine.resultTable)
    ResultView.displayReturnRate(winStats.returnRate)

    println("what?")
}
