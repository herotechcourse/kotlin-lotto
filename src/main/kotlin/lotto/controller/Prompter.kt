package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.OutputView

object Prompter {
    fun askAmount(): Int {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.amount() },
            read = { InputView.readUserAmount() }
        )
    }

    fun askManualTicketsNumbers(amount: Int): Int {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.numberOfManual() },
            read = { InputView.readNumberOfManual(amount) }
        )
    }

    fun askManualNumbers(size: Int): List<Set<Int>> {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.manualNumbers() },
            read = {
                List(size) {
                    InputView.readManualNumbers(size)
                }
            }
        )
    }

    fun askWinningNumbers(): Set<Int> {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.winningNumbers() },
            read = { InputView.readManualNumbers(1) }
        )
    }

    fun askBonusNumber(winningTicket: LottoTicket): LottoNumber {
        return InputView.retryUntilSuccess(
            prompt = { OutputView.Prompt.bonusNumber() },
            read = { InputView.readBonusNumber(winningTicket.toRawSet()) }
        )
    }

}