package lotto.controller


import lotto.domain.LottoTicket
import lotto.services.TicketIssuer
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

        // show a purchased result
        OutputView.Result.purchase(issuedManualTickets, issuedRandomTickets)

        // get winning main numbers
        // get bonus number
        // show winning statistics
    }

    private fun getTotalTicketsNumber(amount: Int) = amount / LottoTicket.PRICE_OF_TICKET

    private fun getRandomTicketsNumber(total: Int, manualNumber: Int): Int {
        require(total >= manualNumber) { "total must be >= $manualNumber" }
        return total - manualNumber
    }

    private fun askAmount(): Int {
        OutputView.Prompt.amount()
        return InputView.readUserAmount()
    }

    private fun askManualTicketsNumbers(amount: Int): Int {
        OutputView.Prompt.numberOfManual()
        return InputView.readNumberOfManual(amount)
    }

    private fun askManualNumbersRaw(size: Int): List<Set<Int>> {
        OutputView.Prompt.manualNumbers()
        return List(size) {
            InputView.readManualNumbers()
        }
    }

    private fun getRandomNumbersRaw(size: Int): List<Set<Int>> {
        // TODO: implement
    }
}