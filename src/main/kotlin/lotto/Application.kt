package lotto

import lotto.controller.LottoController
import lotto.model.TicketFactory
import lotto.model.WinningLogic
import lotto.model.WinningLottoFactory
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGame =
        LottoController(
            InputView,
            ResultView,
            TicketFactory,
            WinningLottoFactory,
            WinningLogic,
        )
    lottoGame.run()
}
