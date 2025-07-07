package lotto

import view.InputView
import view.ResultView

fun main() {
    val amountInput = InputView.getPurchaseAmount()
    val purchaseAmount = Money(amountInput)
    val lottoMachine = LottoMachine(purchaseAmount)
    val lottoTickets = lottoMachine.tickets

    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets)

    val winningNumbers = Lotto(InputView.getWinningNumbers())
    val bonusNumber = LottoNumber.from(InputView.getBonusNumber())

    val game = LottoGame()
    val gameResults = game.play(lottoTickets, winningNumbers, bonusNumber)
    ResultView.viewWinning(gameResults)
    ResultView.viewRate((game.countWinningAmount(gameResults) / purchaseAmount.getValue()).toDouble())
}
