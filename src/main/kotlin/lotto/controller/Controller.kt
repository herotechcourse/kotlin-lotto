package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

object Controller {
    fun run() {
        // get amount
        val amount = getAmount()
        // get manual tickets
        val numberOfManual = getNumberOfManual(amount)
        // get the numbers for manual tickets
        val manualNumbersRaw = getManualNumbers(numberOfManual)
        // show a purchased result
        // get winning main numbers
        // get bonus number
        // show winning statistics
    }

    private fun getAmount(): Int {
        OutputView.Prompt.amount()
        return InputView.readUserAmount()
    }

    private fun getNumberOfManual(amount: Int): Int {
        OutputView.Prompt.numberOfManual()
        return InputView.readNumberOfManual(amount)
    }

    private fun getManualNumbers(numberOfManual: Int): List<Set<Int>> {
        OutputView.Prompt.manualNumbers()
        return List(numberOfManual) {
            InputView.readManualNumbers()
        }
    }
}