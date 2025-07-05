package lotto

class Lotto(var numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "[ERROR] Lotto number size has to be $LOTTO_SIZE."
        }
        require(numbers.all { it in MIN..MAX }) {
            "[ERROR] Range has to be $MIN..$MAX."
        }
        require(numbers.distinct().size == 6) {
            "[ERROR] Duplicates found."
        }
    }

    companion object {
        const val MIN = 0
        const val MAX = 45
        const val LOTTO_SIZE = 6
    }
}
