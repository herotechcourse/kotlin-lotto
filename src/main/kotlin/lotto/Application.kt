package lotto

import view.InputView
import view.ResultView

fun main() {
    val amountInput = InputView.getAmountInput()
    val purchaseAmount = Money(amountInput)
    val lottoMachine = LottoMachine(purchaseAmount)
    val lottoTickets = lottoMachine.tickets

    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets)

    val winningNumbers = Lotto(InputView.getWinningNumbers())
    val bonusNumber = InputView.getBonusNumber()

    val game = LottoGame(lottoTickets, winningNumbers, bonusNumber)

    game.play()

    ResultView.viewWinning(game.results)
    ResultView.viewRate(game.winningAmount, purchaseAmount.value)
}
