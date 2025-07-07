package lotto

private const val NUMBERS_SIZE = 6

class Lotto(numbersList: List<Int>) {
    val numbers = numbersList.map { LottoNumber.from(it) }

    init {
        require(numbers.size == NUMBERS_SIZE) {
            "Size of numbers should be equal $NUMBERS_SIZE"
        }
        require(numbers.toSet().size == NUMBERS_SIZE) {
            "Numbers should be unique"
        }
    }

    fun matchCount(winningNums: List<LottoNumber>): Int {
        val winningNumsSet = winningNums.toSet()
        return numbers.count {
            it in winningNumsSet
        }
    }

    fun containsBonusNum(num: LottoNumber) = num in numbers
}
