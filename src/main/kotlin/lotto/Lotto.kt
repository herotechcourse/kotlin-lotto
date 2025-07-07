package lotto

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "[ERROR] Lotto number size has to be $LOTTO_SIZE."
        }
        require(numbers.distinct().size == 6) {
            "[ERROR] Duplicates found."
        }
    }

    fun hasBonusNumber(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
