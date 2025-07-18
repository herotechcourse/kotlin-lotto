package lotto.domain

import lotto.exceptions.ExceptionMessage

/**
 * the data class contain winning ticket and bonus number to eval user's Lotto tickets
 */
data class WinningCombination(val winningTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(winningTicket.doesNotContains(bonusNumber)) { ExceptionMessage.DUPLICATE }
    }
}
