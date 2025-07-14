package lotto

fun main() {
    val inputView = InputView()
    val lottoMachine = LottoMachine()
    val totalTicketsCalculator = TotalTicketsCalculator()
    val resultView = ResultView()

    val userAmount = inputView.takePurchaseInput()
    val totalPurchasedTickets = totalTicketsCalculator.calculateTickets(userAmount)
    val manualTicketsQuantity: Int = inputView.takeQuantityOfManualTickets(totalPurchasedTickets) ?: 0
    val userManualTicketNumbers = inputView.takeUserManualTicketNumbers(manualTicketsQuantity)

    val manualTickets = lottoMachine.createManualTickets(userManualTicketNumbers)
    val autoTickets = lottoMachine.createGeneratedTickets(totalPurchasedTickets, manualTicketsQuantity)
    val tickets = manualTickets + autoTickets
    resultView.printLottos(tickets)

    val winningNumbers = inputView.takeWinningNumbers()
    val bonusNumber = inputView.takeBonusNumber(winningNumbers)
    val results = lottoMachine.compareTickets(tickets, winningNumbers, bonusNumber)
    resultView.printResult(results)

    val rate = lottoMachine.calculateReturnRate(results, userAmount)
    resultView.printReturnRate(rate)
}
