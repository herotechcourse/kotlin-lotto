package lotto

class Lotto(numbers: List<LottoNumber>) {
    val numbers = numbers.toSet()

    init {
        require(numbers.size == LOTTO_SIZE) { "List should have exactly 6 numbers" }
        require(this.numbers.size == numbers.size) { "All the numbers in the list must be unique" }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
