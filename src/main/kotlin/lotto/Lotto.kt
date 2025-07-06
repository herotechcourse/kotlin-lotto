package lotto

private const val NUMBERS_SIZE = 6

open class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_SIZE) {
            "Size of numbers should be equal $NUMBERS_SIZE"
        }
        require(numbers.toSet().size == NUMBERS_SIZE) {
            "lotto ticket numbers should be unique"
        }
        require(numbers.all { it in 1..45 }) {
            "lotto ticket each number should be between 1 and 45"
        }
    }

    fun matchCount(winningNums: List<Int>): Int {
        return numbers.count {
            it in winningNums
        }
    }

    fun containsBonusNum(num: Int) = num in numbers
}
