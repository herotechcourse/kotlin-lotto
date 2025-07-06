package lotto

object LottoHandler {
    fun start() {
        try {
            val machine = buyTickets()
            val winningTicket = processWinningNumbers()
            val winningNumbers = processBonusNumbers(winningTicket)

            val calculator = Calculator(machine.tickets, winningNumbers)

            val returnRate = calculator.calculateReturnRate(machine.purchaseAmount)
            OutputView.displayWinnings(calculator.results)
            OutputView.displayTotalWinningAmount(calculator.calculateTotalEarnings())
            OutputView.displayReturnRate(returnRate)
        } catch (err: IllegalArgumentException) {
            println(err.message)
        }
    }

    fun buyTickets(): LottoMachine {
        repeat(MAX_ATTEMPT) {
            try {
                val purchaseAmount = InputView.readPurchaseAmount()
                val machine = LottoMachine(purchaseAmount)
                OutputView.displayTickets(machine.tickets)
                OutputView.displayChange(machine.change)
                return machine
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun processWinningNumbers(): Lotto {
        repeat(MAX_ATTEMPT) {
            try {
                val winningNumbers = InputView.readWinningNumbers()
                return Lotto(winningNumbers)
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun processBonusNumbers(winningTicket: Lotto): WinningNumbers {
        repeat(MAX_ATTEMPT) {
            try {
                val bonusNumber = InputView.readBonusNumber()
                val winningNumbers = WinningNumbers(winningTicket, bonusNumber)
                return winningNumbers
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private const val MAX_ATTEMPT = 5
    private const val MAX_ATTEMPT_MESSAGE = "Too many attempts"
}
