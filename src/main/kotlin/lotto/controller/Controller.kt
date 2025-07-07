package lotto.controller


import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningCombination
import lotto.services.GameResult
import lotto.domain.RandomNumbers
import lotto.services.TicketIssuer
import lotto.services.TicketsEvaluator
import lotto.view.InputView
import lotto.view.OutputView

object Controller {
    fun run() {
        // get amount
        val amount = askAmount()
        val totalTicketsNumber = getTotalTicketsNumber(amount)

        // get manual tickets
        val manualTicketsNumber = askManualTicketsNumbers(amount)

        // get the numbers for manual tickets
        val manualNumbersRaw = askManualNumbersRaw(manualTicketsNumber)
        val issuedManualTickets = TicketIssuer.with(manualNumbersRaw)

        // get random tickets
        val randomTicketsNumber = getRandomTicketsNumber(totalTicketsNumber, manualTicketsNumber)
        val randomNumbersRaw = getRandomNumbersRaw(randomTicketsNumber)
        val issuedRandomTickets = TicketIssuer.with(randomNumbersRaw)

        val totalIssuedTickets = issuedManualTickets + issuedRandomTickets

        // show a purchased result
        OutputView.Result.purchase(issuedManualTickets, issuedRandomTickets)
        OutputView.Result.issuedTickets(totalIssuedTickets)

        // get winning main numbers
        val winningNumbersRaw = askWinningNumbers()
        val winningTicket = LottoTicket.from(winningNumbersRaw)

        // get bonus number
        val bonusNumber = askBonusNumber(winningNumbersRaw)
        val winningCombination = WinningCombination(winningTicket, bonusNumber)

        val ticketRanks = TicketsEvaluator.runWith(totalIssuedTickets, winningCombination)

        val returnRate = TicketsEvaluator.getTotalRate(ticketRanks, amount)
        // get gameResult
        val gameResult = GameResult(totalIssuedTickets, winningCombination, amount, ticketRanks, returnRate)

        // show winning statistics
        OutputView.Result.winningStatistics(gameResult)
    }

    private fun getTotalTicketsNumber(amount: Int) = amount / LottoTicket.PRICE_OF_TICKET

    private fun getRandomTicketsNumber(total: Int, manualNumber: Int): Int {
        require(total >= manualNumber) { "total must be >= $manualNumber" }
        return total - manualNumber
    }

    private fun askAmount(): Int {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.amount() },
            read = { InputView.readUserAmount() }
        )
    }

    private fun askManualTicketsNumbers(amount: Int): Int {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.numberOfManual() },
            read = { InputView.readNumberOfManual(amount) }
        )
    }

    private fun askManualNumbersRaw(size: Int): List<Set<Int>> {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.manualNumbers() },
            read = {
                List(size) {
                    InputView.readManualNumbers(size)
                }
            }
        )
    }

    private fun getRandomNumbersRaw(size: Int): List<Set<Int>> {
        return List(size) { RandomNumbers.get() }
    }

    private fun askWinningNumbers(): Set<Int> {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.winningNumbers() },
            read = { InputView.readManualNumbers(1) }
        )
    }

    private fun askBonusNumber(winningInput: Set<Int>): LottoNumber {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.bonusNumber() },
            read = { InputView.readBonusNumber(winningInput) }
        )
    }
}