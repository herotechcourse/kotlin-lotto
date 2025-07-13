package lotto

object LottoHandler {
    fun start() {
        try {
            val purchase = pay()

            val tickets = buyTickets(purchase)

            val winningTicket = processWinningNumbers()
            val winningNumbers = processBonusNumbers(winningTicket)

            doStatistics(winningNumbers, tickets, purchase)
        } catch (err: IllegalArgumentException) {
            println(err.message)
        }
    }

    private fun pay(): Purchase {
        repeat(MAX_ATTEMPT) {
            try {
                return Purchase(Money(InputView.readPurchaseAmount()))
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun reserveManualTickets(purchase: Purchase): Int {
        repeat(MAX_ATTEMPT) {
            try {
                val manualTicketsCount = InputView.readNumberOfManualTickets()
                purchase.checkManualTicketsCount(manualTicketsCount)
                return manualTicketsCount
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun buyManualTickets(ticketCount: Int): List<Lotto> {
        repeat(MAX_ATTEMPT) {
            try {
                InputView.promptForManualTickets()
                return List(ticketCount) {
                    Lotto.from(InputView.readManualTickets())
                }
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun buyAutomaticTickets(count: Int): List<Lotto> {
        val machine = LottoMachine()
        repeat(MAX_ATTEMPT) {
            try {
                return machine.generateTickets(count)
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun buyTickets(purchase: Purchase): List<Lotto> {
        val manualTicketsCount = reserveManualTickets(purchase)
        val automaticTicketsCount = purchase.calculateAutomaticTicketsCount(manualTicketsCount)

        val manualTickets = buyManualTickets(manualTicketsCount)
        val automaticTickets = buyAutomaticTickets(automaticTicketsCount)
        val tickets: List<Lotto> = manualTickets + automaticTickets
        OutputView.displayCombinedTickets(tickets, manualTicketsCount, automaticTicketsCount)
        OutputView.displayChange(purchase.change)
        return tickets
    }

    private fun processWinningNumbers(): Lotto {
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

    private fun processBonusNumbers(winningTicket: Lotto): WinningNumbers {
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

    private fun doStatistics(winningNumbers: WinningNumbers, tickets: List<Lotto>, purchase: Purchase) {
        val statistics = Statistics(winningNumbers)
        val results = statistics.calculateResults(tickets)
        val totalEarnings = statistics.calculateTotalEarnings(results)
        val returnRate = statistics.calculateReturnRate(totalEarnings, purchase.amount)

        OutputView.displayWinnings(results)
        OutputView.displayTotalWinningAmount(totalEarnings)
        OutputView.displayReturnRate(returnRate)
    }

    private const val MAX_ATTEMPT = 5
    private const val MAX_ATTEMPT_MESSAGE = "Too many attempts"
}
