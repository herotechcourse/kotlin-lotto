package lotto

class Lotto(val lottoNumbers: List<Int>) {
    init {
        require(lottoNumbers.count() == 6)
        require(isInRange(lottoNumbers))
        require(isNotDuplicated(lottoNumbers))
    }

    fun getNumbers(): List<Int> {
        return lottoNumbers
    }

    private fun isInRange(lottoNumbers: List<Int>): Boolean {
        var isInRange = true
        lottoNumbers.forEach { number ->
            if (number !in 1..45) {
                isInRange = false
            }
        }
        return isInRange
    }

    private fun isNotDuplicated(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.count() == lottoNumbers.toSet().count()
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
            if (number.toInt() in getNumbers()) {
                countMatches++
            }
        }
        return countMatches
    }

    private fun compareToBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in getNumbers()
    }
}
