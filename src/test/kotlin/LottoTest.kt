package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throw error exception when amount of numbers aren't 6`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `throw error exception when numbers are out of the range between 1 and 45`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `throw error exception when numbers are duplicated`() {
        val lottoNumbers = listOf(1, 2, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `6 matching numbers without bonus returns FIRST prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 8
        assertEquals(
            Rank.FIRST,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `5 matching numbers with bonus returns SECOND prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 7
        assertEquals(
            Rank.SECOND,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `5 matching numbers without bonus returns THIRD prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 6
        assertEquals(
            Rank.THIRD,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `4 matching numbers without bonus returns FOUR prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 44, 45))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 8
        assertEquals(
            Rank.FOURTH,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `3 matching numbers without bonus returns FIFTH prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 43, 44, 45))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 6
        assertEquals(
            Rank.FIFTH,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `less than 3 matching numbers without bonus returns MISS`() {
        val lotto = Lotto(listOf(1, 2, 30, 40, 41, 42))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 40
        assertEquals(
            Rank.MISS,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }
}
