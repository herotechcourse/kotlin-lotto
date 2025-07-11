package lotto

object LottoHandler {
    fun start() {
        try {
            val purchase = pay()

            reserveManualTickets(purchase)

            val manualTickets = buyManualTickets(purchase.manualTicketsCount)
            val automaticTickets = buyAutomaticTickets(purchase)
            val tickets: List<Lotto> = manualTickets + automaticTickets
            displayTicketsAndChange(tickets, purchase)

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

    fun pay(): Purchase {
        repeat(MAX_ATTEMPT) {
            try {
                return Purchase(InputView.readPurchaseAmount())
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun reserveManualTickets(purchase: Purchase) {
        repeat(MAX_ATTEMPT) {
            try {
                purchase.manualTicketsCount = InputView.readNumberOfManualTickets()
                return
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun buyManualTickets(ticketCount: Int): List<Lotto> {
        repeat(MAX_ATTEMPT) {
            try {
                val tickets = mutableListOf<Lotto>()
                InputView.promptForManualTickets()
                repeat(ticketCount) {
                    tickets.add(Lotto.from(InputView.readManualTickets()))
                }
                return tickets.toList()
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    fun displayTicketsAndChange(tickets: List<Lotto>, purchase: Purchase) {
        OutputView.displayCombinedTickets(tickets, purchase.manualTicketsCount, purchase.automaticTicketsCount)
        OutputView.displayChange(purchase.change)
    }

    fun buyAutomaticTickets(purchase: Purchase): List<Lotto> {
        val machine = LottoMachine()
        repeat(MAX_ATTEMPT) {
            try {
                val automaticTickets = machine.generateTickets(purchase.automaticTicketsCount)
                return automaticTickets
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
