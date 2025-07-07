package lotto.controller


import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.RandomNumbers
import lotto.domain.WinningCombination
import lotto.domain.GameResult
import lotto.services.TicketIssuer
import lotto.services.TicketsEvaluator
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    fun run() {
        // get amount
        val amount = askAmount()
        val totalTicketsNumber = getTotalTicketsNumber(amount)

        // get random tickets
        val randomNumbersRaw = getRandomNumbersRaw(totalTicketsNumber)
        val totalIssuedTickets = TicketIssuer.with(randomNumbersRaw)

        // show a purchased result
        OutputView.Result.purchase(totalIssuedTickets)
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

    private fun askAmount(): Int {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.amount() },
            read = { InputView.readUserAmount() }
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