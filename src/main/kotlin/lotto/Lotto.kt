package lotto

class Lotto(var numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            throw IllegalArgumentException()
        }
        require(numbers.all { it in MIN..MAX }) {
            throw IllegalArgumentException()
        }
        require(numbers.distinct().size == 6) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        const val MIN = 0
        const val MAX = 45
        const val LOTTO_SIZE = 6
    }
}
