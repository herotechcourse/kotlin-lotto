package lotto

object Lotto {
    fun run() {
        val amountOfMoney = retryable { InputView.getPurchaseAmount() }
        val totalTickets = amountOfMoney / LottoTicket.COST_OF_TICKET

        val manualCount = retryable { InputView.getManualTicketCount(totalTickets) }
        val manualTickets = retryable { InputView.getManualTickets(manualCount) }

        val autoCount = totalTickets - manualCount
        val autoTickets = LottoPrinter.generateLottoTickets(autoCount)

        val allTickets = manualTickets + autoTickets

        ResultView.displayTicketPurchaseSummary(manualCount, autoCount)
        ResultView.displayTickets(allTickets)

        val winningNumbers = retryable { InputView.getLastWeekWinningNumbers() }
        val bonusNumber = retryable { InputView.getBonusNumber() }

        val machine: LottoMachine = LottoMachine(winningNumbers, bonusNumber)
        val resultTable: Map<Rank, Int> = machine.createResultTable(allTickets)

        val winningMoney = WinStatCalculator.calculateWinningMoney(resultTable)
        val returnRate = WinStatCalculator.calculateReturnRate(winningMoney, amountOfMoney)

        ResultView.displayFinalResults(resultTable, returnRate)
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
