package lotto.domain

object NumberGenerator {
    fun shuffledRandomNumbers(): Set<Int> {
        val shuffled =
            createNumbers(
                LottoNumber.MIN_RANGE_NUMBER,
                LottoNumber.MAX_RANGE_NUMBER,
            ).shuffled()
        return sufficientSizeNumbers(shuffled)
    }

    internal fun sufficientSizeNumbers(numbers: List<Int>): Set<Int> {
        require(numbers.distinct().size == LottoTicket.SUFFICIENT_SIZE)
        return numbers
            .take(LottoTicket.SUFFICIENT_SIZE)
            .sorted()
            .toCollection(linkedSetOf())
    }

    internal fun shuffledNumbers(numbers: List<Int>): List<Int> {
        return numbers.shuffled()
    }

    internal fun createNumbers(
        min: Int,
        max: Int,
    ): List<Int> {
        val numbers = (min..max).distinct()
        require(max - min >= 0) { "max must be greater than min" }
        return numbers
    }
}
