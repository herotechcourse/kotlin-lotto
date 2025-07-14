package lotto.core

import lotto.model.Lotto
import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class LottoTest {
    @MethodSource("factory")
    @ParameterizedTest
    fun `lotto should have 6 numbers`(ticket: Set<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto.fromInts(ticket)
        }
    }

    @Test
    fun `lotto should have 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            Lotto.fromInts(setOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `check the right number of matches between two Lotto with 6 matches`() {
        val ticket = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val matches = ticket.countMatches(winningLotto)
        assertThat(matches).isEqualTo(6)
    }

    @Test
    fun `check if the bonus number is matched`() {
        val ticket = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(1)
        assertThat(ticket.containsBonus(bonusNumber)).isTrue()
    }

    @Test
    fun `check if the bonus number is not matched`() {
        val ticket = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(7)
        assertThat(ticket.containsBonus(bonusNumber)).isFalse()
    }

    @Test
    fun `GetLottoNumbers should return the right set of numbers`() {
        val lotto = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val expectation =
            setOf<LottoNumber>(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
            )
        assertThat(lotto.lottoNumbers).isEqualTo(expectation)
    }

    companion object {
        @JvmStatic
        fun factory(): Set<Set<Int>> {
            return setOf(
                setOf(1, 2, 3, 4, 5),
                setOf(1, 2, 3, 4, 5, 6, 7),
            )
        }
    }
}
