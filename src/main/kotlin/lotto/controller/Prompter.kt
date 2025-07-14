package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.OutputView

object Prompter {
    fun askAmount(): Int {
        return InputView.retriable(
            prompt = { OutputView.Prompt.amount() },
            read = { InputView.readUserAmount() },
        )
    }

    fun askManualTicketsNumbers(amount: Int): Int {
        return InputView.retriable(
            prompt = { OutputView.Prompt.numberOfManual() },
            read = { InputView.readManualSize(amount) },
        )
    }

    fun askManualNumbers(size: Int): List<Set<Int>> {
        return InputView.retriable(
            prompt = { OutputView.Prompt.manualNumbers() },
            read = {
                List(size) {
                    InputView.readManualNumbers()
                }
            },
        )
    }

    fun askWinningNumbers(): Set<Int> {
        return InputView.retriable(
            prompt = { OutputView.Prompt.winningNumbers() },
            read = { InputView.readManualNumbers() }
        )
    }

    fun askBonusNumber(winningTicket: LottoTicket): LottoNumber {
        return InputView.retriable(
            prompt = { OutputView.Prompt.bonusNumber() },
            read = { InputView.readBonusNumber(winningTicket.toRawSet()) }
        )
    }

}