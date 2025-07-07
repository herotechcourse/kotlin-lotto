package lotto

import kotlin.collections.shuffled
import kotlin.collections.sorted

class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.count() == 6)
        require(isNotDuplicated(lottoNumbers))
    }

    fun getLottoNumbersAsInt(): List<Int> {
        return lottoNumbers.map { it.value }
    }

    private fun isNotDuplicated(lottoNumbers: List<LottoNumber>): Boolean {
        return lottoNumbers.count() == lottoNumbers.map { it.value }.toSet().count()
    }

    fun calculateRank(
        winningNumbers: List<String>,
        bonusNumber: Int,
    ): Rank {
        var hasBonus = false
        val matches = compareToWinningNumbers(winningNumbers)
        if (matches == 5) {
            hasBonus = compareToBonusNumber(bonusNumber)
        }
        val rank = Rank.valueOf(countOfMatch = matches, matchBonus = hasBonus)
        return rank
    }

    private fun compareToWinningNumbers(winningNumbers: List<String>): Int {
        var countMatches = 0
        winningNumbers.forEach { number ->
            if (number.toInt() in getLottoNumbersAsInt()) {
                countMatches++
            }
        }
        return countMatches
    }

    private fun compareToBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in getLottoNumbersAsInt()
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45

        fun create(): Lotto {
            return Lotto(generateNumbers())
        }

        private fun generateNumbers(): List<LottoNumber> {
            val randomNumbers =
                (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER)
                    .shuffled()
                    .take(6)
                    .sorted()
                    .map {
                        LottoNumber(it)
                    }
            return randomNumbers
        }
    }
}
