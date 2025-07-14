package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.TicketFactory
import lotto.model.WinningLogic
import lotto.model.WinningLotto
import lotto.model.WinningLottoFactory
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val ticketFactory: TicketFactory,
    private val winningLotto: WinningLottoFactory,
    private val winningLogic: WinningLogic,
) {
    fun run() {
        val purchaseAmount = inputView.purchaseAmountInput()
        val tickets = handlePurchase(purchaseAmount)
        val winningLotto = handleWinningLotto()
        val result = winningLogic.determineWinningTickets(tickets, winningLotto)
        resultView.displayWinningStatistics(result)
    }

    private fun handlePurchase(purchaseAmount: Int): List<Lotto> {
        val numberOfTickets = ticketFactory.calculateNumberOfTickets(purchaseAmount)
        val manualTicketsNumber = inputView.getManualTicketsNumber(numberOfTickets)
        val automaticTicketsNumber = numberOfTickets - manualTicketsNumber
        val manualTicketsList = inputView.getManualTickets(manualTicketsNumber)
        resultView.displayNumberOfTicketsInput(manualTicketsNumber, automaticTicketsNumber)
        val tickets = ticketFactory.handleTicketGeneration(manualTicketsList, automaticTicketsNumber)
        resultView.displayTickets(tickets)
        return tickets
    }

    private fun handleWinningLotto(): WinningLotto {
        val winningLottoList = inputView.winningNumbersInput()
        val bonusNumber = LottoNumber.from(inputView.bonusNumberInput(winningLottoList))
        val winningLotto = winningLotto.from(winningLottoList, bonusNumber)
        return winningLotto
    }
}
