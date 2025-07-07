package lotto

import lotto.controller.Controller
import lotto.view.OutputView
import kotlin.system.exitProcess

/**
 * This app is a Lotto app that receives an amount from the user to purchase Lotto tickets.
 * The app waits for the winning numbers from the week and a bonus number, and with that
 * it will generate all the winning statistics for the user.
 *
 * @exception Exception to protect in case of unexpected behavior.
 */
fun main() {
    try {
        val controller = Controller
        controller.run()
    } catch (exception: Exception) {
        OutputView.Prompt.error(exception)
        exitProcess(1)
    }
}
