package lotto

fun main() {
    val amountOfMoney = InputView.getPurchaseAmount()
    val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    val machine = LottoMachine(amountOfMoney, lastWeekWinningNumbers, bonusNumber)

    println("what?")
}
