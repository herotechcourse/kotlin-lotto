package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class StatisticsTest {
    @Test
    fun `Count number of matches between Lotto ticket and winning numbers`() {
        val lotto = Lotto.from(listOf(3, 8, 27, 30, 35, 44))
        val numbers = Lotto.from(listOf(3, 8, 27, 4, 5, 6))
        val winningNumbers = WinningNumbers(numbers, LottoNumber.from(7))

        val statistics = Statistics(mutableListOf<Lotto>(lotto), 3000, winningNumbers)
        assertEquals(statistics.results.contains(Rank.FIFTH), true)
    }

    @Test
    fun `test return rate`() {
        val tickets =
            mutableListOf(
                // FIRST
                Lotto.from(listOf(3, 8, 27, 4, 5, 6)),
                // THIRD
                Lotto.from(listOf(3, 8, 27, 4, 5, 43)),
                Lotto.from(listOf(7, 11, 16, 35, 36, 44)),
                Lotto.from(listOf(1, 8, 11, 31, 41, 42)),
                Lotto.from(listOf(13, 14, 16, 38, 42, 45)),
            )
        val numbers = Lotto.from(listOf(3, 8, 27, 4, 5, 6))
        val winningNumbers = WinningNumbers(numbers, LottoNumber.from(7))
        val statistics = Statistics(tickets, 5000, winningNumbers)
        assertEquals(statistics.returnRate, 400300f)
    }
}
