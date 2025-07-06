package lotto

private const val NUMBERS_SIZE = 6

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_SIZE) {
            "Size of numbers should be equal $NUMBERS_SIZE"
        }
        require(numbers.all { it in 1..45 }) {
            "lotto ticket each number should be between 1 and 45"
        }
    }

    fun matchCount(winningNums: List<Int>): Int {
        val winningNumsSet = winningNums.toSet()
        return numbers.count {
            it in winningNumsSet
        }
    }

    fun containsBonusNum(num: Int) = num in numbers
}
