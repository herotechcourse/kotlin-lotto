package controller

import lotto.BonusNumber
import lotto.Lotto
import lotto.LottoGame
import lotto.LottoNumbers
import lotto.PurchaseResult
import view.InputView
import view.ResultView

object LottoController {
    fun start() {
        val amountInput = InputView.getAmountInput()
        val manualCount = InputView.getManualTicketCount()
        InputView.getInputForNumber()

        val manualTickets =
            List(manualCount) {
                InputView.getManualNumbers()
            }

        val purchaseResults = PurchaseService.purchase(amountInput, manualTickets)
        showPurchasedTickets(purchaseResults)

        val (winningNumbers, bonusNumber) = getWinningNumbersAndBonus()

        val game =
            LottoGame(
                playersTickets = purchaseResults.deliverTickets(),
                winningNumbers = Lotto(winningNumbers),
                bonusNumber,
            )

        showResults(game, purchaseResults.purchaseAmount())
    }

    private fun showPurchasedTickets(purchaseResults: PurchaseResult) {
        purchaseResults.renderTicketsTo(ResultView)
    }

    private fun getWinningNumbersAndBonus(): Pair<LottoNumbers, BonusNumber> {
        val winningNumbers = LottoNumbers.of(InputView.getWinningNumbers())
        val bonusNumber = BonusNumber.of(InputView.getBonusNumber(), winningNumbers.numbers)
        return winningNumbers to bonusNumber
    }

    private fun showResults(
        game: LottoGame,
        purchaseAmount: Int,
    ) {
        ResultView.viewWinning((game.results))
        ResultView.viewRate(game.winningAmount, purchaseAmount)
    }
}
