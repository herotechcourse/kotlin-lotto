package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [MIN_RANGE_NUMBER - 1, MAX_RANGE_NUMBER + 1])
    @ParameterizedTest
    fun `throw if lotto number not in range`(value: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(value)
        }
    }

    @ValueSource(ints = [MIN_RANGE_NUMBER, MAX_RANGE_NUMBER])
    @ParameterizedTest
    fun `do not throw if lotto number in range`(value: Int) {
        assertDoesNotThrow {
            LottoNumber.from(value)
        }
    }

    @Test
    fun `should return same instance for same input`() {
        val number = LottoNumber.from(MIN_RANGE_NUMBER)
        assertThat(LottoNumber.from(MIN_RANGE_NUMBER)).isEqualTo(number)
        assertThat(LottoNumber.from(MIN_RANGE_NUMBER)).isSameAs(number)
    }

    companion object {
        private const val MIN_RANGE_NUMBER = LottoNumber.MIN_RANGE_NUMBER
        private const val MAX_RANGE_NUMBER = LottoNumber.MAX_RANGE_NUMBER
    }
}
