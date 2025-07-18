package lotto.controller

import lotto.domain.LottoTicket
import lotto.domain.WinningCombination

object LottoWinningCreator {
    fun fromUserInput(): WinningCombination {
        val winningTicket = LottoTicket.from(Prompter.askWinningNumbers())
        return WinningCombination(winningTicket, Prompter.askBonusNumber(winningTicket))
    }
}
