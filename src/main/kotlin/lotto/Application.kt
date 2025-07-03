package lotto

fun main() {
    val inputView = InputView()
    val userAmount = inputView.takePurchaseInput()
    val lottoMachine = LottoMachine(userAmount)

    val tickets = lottoMachine.createTickets() // move userAmount to here
    val resultView = ResultView()

    resultView.printLottos(tickets)
    val winningNumbers = inputView.takeWinningNumbers()
    val bonusNumber = inputView.takeBonusNumber(winningNumbers)
    val results = lottoMachine.compareTickets(tickets, winningNumbers, bonusNumber)
    resultView.printResult(results)

    val rate = lottoMachine.calculateReturnRate(results, userAmount)
    resultView.printReturnRate(rate)
}
