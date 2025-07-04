package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `throw if lotto number not in range, too small`() {
        assertThrows<IllegalArgumentException> {
            val numberZero = LottoNumber.from(LottoNumber.MIN_RANGE_NUMBER - 1)
        }
    }

    @Test
    fun `throw if lotto number not in range, too big`() {
        assertThrows<IllegalArgumentException> {
            val numberZero = LottoNumber.from(LottoNumber.MAX_RANGE_NUMBER + 1)
        }
    }

    @Test
    fun `do not throw if lotto number in range`() {
        assertDoesNotThrow {
            val numberOne = LottoNumber.from(LottoNumber.MIN_RANGE_NUMBER)
            val numberTwo = LottoNumber.from(LottoNumber.MAX_RANGE_NUMBER)
        }
    }
}