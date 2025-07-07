package lotto

fun main() {
    val inputView = InputView()
    val lottoMachine = LottoMachine()
    val resultView = ResultView()

    val userAmount = inputView.takePurchaseInput()
    val tickets = lottoMachine.createTickets(userAmount)
    resultView.printLottos(tickets)

    val winningNumbers = inputView.takeWinningNumbers()
    val bonusNumber = inputView.takeBonusNumber(winningNumbers)
    val results = lottoMachine.compareTickets(tickets, winningNumbers, bonusNumber)
    resultView.printResult(results)

    val rate = lottoMachine.calculateReturnRate(results, userAmount)
    resultView.printReturnRate(rate)
}
