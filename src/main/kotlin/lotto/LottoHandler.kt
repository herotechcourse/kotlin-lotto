package lotto

object LottoHandler {
    private val machine = LottoMachine()
    private var tickets = listOf<Lotto>()
    fun start() {
        try {
            val purchase = buyTickets()
            val winningTicket = processWinningNumbers()
            val winningNumbers = processBonusNumbers(winningTicket)

            val statistics = Statistics(tickets, purchase.amount, winningNumbers)

            OutputView.displayWinnings(statistics.results)
            OutputView.displayTotalWinningAmount(statistics.totalEarnings)
            OutputView.displayReturnRate(statistics.returnRate)
        } catch (err: IllegalArgumentException) {
            println(err.message)
        }
    }

    fun buyTickets(): Purchase {
        repeat(MAX_ATTEMPT) {
            try {
                val purchase = Purchase(InputView.readPurchaseAmount())
                tickets = machine.generateTickets(purchase.ticketCount)
                OutputView.displayTickets(tickets)
                OutputView.displayChange(purchase.change)
                return purchase
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
                return Lotto.from(winningNumbers)
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun processBonusNumbers(winningTicket: Lotto): WinningNumbers {
        repeat(MAX_ATTEMPT) {
            try {
                val bonusNumber = LottoNumber.from(InputView.readBonusNumber())
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
