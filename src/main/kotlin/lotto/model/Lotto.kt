package lotto.model

import lotto.view.Error

data class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { Error.INVALID_LOTTO_SIZE.message } // Lotto has to be 6 numbers
    }

    val lottoNumbers
        get() = numbers

    fun countMatches(winningTicket: Lotto): Int {
        return this.numbers.intersect(winningTicket.numbers).size
    }

    fun containsBonus(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        fun fromInts(numbers: Set<Int>): Lotto {
            return Lotto(numbers.map(LottoNumber::from).toSet())
        }
    }
}
