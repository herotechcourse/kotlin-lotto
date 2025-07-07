package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `if number is not in range from 1 to 45 should thrown`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(46)
        }
    }

    @Test
    fun `if number is not in range from 1 to 45 should thrown 2`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(0)
        }
    }
}
