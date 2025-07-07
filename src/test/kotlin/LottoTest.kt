package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throw error exception when amount of numbers aren't 6`() {
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
            )
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `throw error exception when numbers are duplicated`() {
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(2),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(45),
            )
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `6 matching numbers without bonus returns FIRST prize`() {
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        val lotto = Lotto(lottoNumbers)
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
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        val lotto = Lotto(lottoNumbers)
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
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        val lotto = Lotto(lottoNumbers)
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
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(44),
                LottoNumber(45),
            )
        val lotto = Lotto(lottoNumbers)
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
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(43),
                LottoNumber(44),
                LottoNumber(45),
            )
        val lotto = Lotto(lottoNumbers)
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
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(30),
                LottoNumber(40),
                LottoNumber(41),
                LottoNumber(42),
            )
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 40
        assertEquals(
            Rank.MISS,
            lotto.calculateRank(winningNumbers, bonusNumber),
            "Rate result is different than expected",
        )
    }
}
