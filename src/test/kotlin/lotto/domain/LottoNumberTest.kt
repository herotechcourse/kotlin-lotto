package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `throw if lotto number not in range`() {
        assertThrows<IllegalArgumentException> {
            val numberZero = LottoNumber.from(0)
        }
    }
}