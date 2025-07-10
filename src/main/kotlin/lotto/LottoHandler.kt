package lotto

import lotto.view.InputView
import lotto.view.OutputView

object LottoHandler {
    fun start() {
        try {
            val purchaseAmount = processPurchaseAmount()
            val enteredTicketCount = processTicketCount()

            val machine =
                LottoMachine(
                    purchaseAmount,
                    enteredTicketCount,
                )

            val manualTickets = readManualTickets(machine.manualTicketCount)
            machine.appendManualTickets(manualTickets)

            OutputView.printTicketCount(
                machine.enteredTicketCount,
                machine.generatedTicketCount,
            )
            OutputView.displayTickets(machine.tickets)
            OutputView.displayChange(machine.change)

            val winningTicket = readTicket()
            val bonusNumber = readBonusNumbers()
            val winningNumbers = WinningNumbers(winningTicket, bonusNumber)

            val calculator = Calculator(machine.tickets, winningNumbers)

            val returnRate = calculator.calculateReturnRate(machine.purchaseAmount)
            OutputView.displayWinnings(calculator.results)
            OutputView.displayTotalWinningAmount(calculator.calculateTotalEarnings())
            OutputView.displayReturnRate(returnRate)
        } catch (err: IllegalArgumentException) {
            OutputView.displayError(err.message)
        }
    }

    private fun <T> readInput(block: () -> T): T {
        repeat(MAX_ATTEMPT) {
            try {
                return block()
            } catch (err: IllegalArgumentException) {
                OutputView.displayError(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun processPurchaseAmount(): PurchaseAmount {
        return readInput {
            val purchaseAmount = InputView.readPurchaseAmount()
            PurchaseAmount(purchaseAmount)
        }
    }

    private fun processTicketCount(): EnteredTicketCount {
        return readInput {
            EnteredTicketCount(InputView.readManualTicketCount())
        }
    }

    private fun readTicket(): Lotto {
        return readInput {
            val winningNumbers = convertLottoNumbers(InputView.readWinningTicket())
            Lotto(winningNumbers)
        }
    }

    private fun readBonusNumbers(): LottoNumber {
        return readInput {
            val number = InputView.readBonusNumber()
            LottoNumber.from(number)
        }
    }

    private fun readManualTickets(count: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(count) {
            tickets.add(Lotto(convertLottoNumbers(InputView.readManualTicket())))
        }
        return tickets
    }

    private fun convertLottoNumbers(numbers: List<Int>): List<LottoNumber> {
        return numbers.map(LottoNumber::from)
    }

    private const val MAX_ATTEMPT = 5
    private const val MAX_ATTEMPT_MESSAGE = "Too many attempts"
}
