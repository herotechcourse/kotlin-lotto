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
}
