package lotto

import view.InputView
import view.ResultView

fun main() {
    val purchaseAmount = Money(InputView.getPurchaseAmount())
    val lottoMachine = LottoMachine()
    val manuelTicketsNumber = InputView.getNumberOfManuelTickets()
    val totalTicketsNumber = purchaseAmount.value / TICKET_PRICE
    val lottoTickets =
        lottoMachine.issueTickets(manuelTicketsNumber) {
            InputView.getNumbersForTicket()
        } +
            lottoMachine.issueTickets(totalTicketsNumber - manuelTicketsNumber) {
                Generator.randomNumber()
            }

    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets)

    val winningNumbers = Lotto(InputView.getWinningNumbers().map { LottoNumber.from(it) })
    val bonusNumber = LottoNumber.from(InputView.getBonusNumber())

    val game = LottoGame()
    val gameResults = game.play(lottoTickets, winningNumbers, bonusNumber)
    ResultView.viewWinning(gameResults)
    ResultView.viewRate((game.countWinningAmount(gameResults).value / purchaseAmount.value).toDouble())
}
