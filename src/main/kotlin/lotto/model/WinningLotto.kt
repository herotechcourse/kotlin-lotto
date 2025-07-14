package lotto.model

import lotto.view.Error

data class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(!lotto.containsBonus(bonusNumber)) { throw IllegalArgumentException(Error.BONUS.message) }
    }

    fun countMatches(other: Lotto): Int {
        return lotto.countMatches(other)
    }

    fun isBonusMatched(lotto: Lotto): Boolean = lotto.containsBonus(bonusNumber)
}
