package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

private const val NUMBERS_SIZE = 6

class LottoTest {
    @Test
    fun `if lotto ticket have over 6 numbers should be thrown an error`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber.from(it) })
        }
    }

    @Test
    fun `if lotto ticket should have 6 numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        assertTrue(lotto.numbers.size == NUMBERS_SIZE)
    }

    @Test
    fun `if lotto ticket numbers are not unique thrown`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber.from(it) })
        }
    }

    @Test
    fun `if lotto ticket each number is not in range between 1 and 45 thrown`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(56, 1, 2, 3, 4, 5).map { LottoNumber.from(it) })
        }
    }

    @Test
    fun `lotto ticket should return match count`() {
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10).map { LottoNumber.from(it) })
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val matchCount = lotto.matchCount(winningLotto.numbers)
        assertThat(matchCount).isEqualTo(2)
    }

    @Test
    fun `lotto ticket should check bonus number`() {
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10).map { LottoNumber.from(it) })
        val bonusNum = 10
        val result = lotto.containsBonusNum(LottoNumber.from(bonusNum))
        assertTrue(result)
    }
}
