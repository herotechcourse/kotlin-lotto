package lotto.domain

object NumberGenerator {
    fun shuffledRandomNumbers(): Set<Int> {
        val numbers =
            createNumbers(
                LottoNumber.MIN_RANGE_NUMBER,
                LottoNumber.MAX_RANGE_NUMBER,
            ).shuffled()
        return sufficientSizeNumbers(numbers)
    }

    internal fun sufficientSizeNumbers(numbers: List<Int>): Set<Int> {
        return numbers
            .take(LottoTicket.SUFFICIENT_SIZE)
            .sorted()
            .toCollection(linkedSetOf())
    }

    internal fun createNumbers(
        min: Int,
        max: Int,
    ): List<Int> {
        require(max - min >= 0) { "max must be greater than or equal to min" }
        return (min..max).toList()
    }
}
