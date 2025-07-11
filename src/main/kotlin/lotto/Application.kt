package lotto

import view.InputView
import view.ResultView

fun main() {
    val purchaseAmount = Money(InputView.getPurchaseAmount())
    val purchasedTicketNumber = PurchasedTicketsNumber(InputView.getNumberOfManuelTickets(), purchaseAmount)
    val lottoMachine = LottoMachine(purchasedTicketNumber)
    val lottoTickets = lottoMachine.issueTickets()

    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets)

    val winningNumbers = Lotto(InputView.getWinningNumbers().map { LottoNumber.from(it) })
    val bonusNumber = LottoNumber.from(InputView.getBonusNumber())

    val game = LottoGame()
    val gameResults = game.play(lottoTickets, winningNumbers, bonusNumber)
    ResultView.viewWinning(gameResults)
    ResultView.viewRate((game.countWinningAmount(gameResults).value / purchaseAmount.value).toDouble())
}
