package lotto.domain

object NumberGenerator {
    fun get(): Set<Int> {
        return (LottoNumber.MIN_RANGE_NUMBER..LottoNumber.MAX_RANGE_NUMBER)
            .shuffled()
            .take(LottoTicket.SUFFICIENT_SIZE)
            .sorted()
            .toCollection(linkedSetOf())
    }
}