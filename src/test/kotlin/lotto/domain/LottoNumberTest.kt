package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ValueSource(ints = [MIN_RANGE_NUMBER - 1, MAX_RANGE_NUMBER + 1])
    @ParameterizedTest
    fun `throw if lotto number not in range`(value: Int) {
        assertThrows<IllegalArgumentException> {
            val number = LottoNumber.from(value)
        }
    }

    @ValueSource(ints = [MIN_RANGE_NUMBER, MAX_RANGE_NUMBER])
    @ParameterizedTest
    fun `do not throw if lotto number in range`(value: Int) {
        assertDoesNotThrow {
            val number = LottoNumber.from(value)
        }
    }

    companion object {
        private const val MIN_RANGE_NUMBER = LottoNumber.MIN_RANGE_NUMBER
        private const val MAX_RANGE_NUMBER = LottoNumber.MAX_RANGE_NUMBER
    }
}