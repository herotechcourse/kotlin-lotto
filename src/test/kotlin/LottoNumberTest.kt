package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `throw error exception when number is out of the range between 1 and 45`() {
        for (i in 1..45) {
            LottoNumber(i)
        }
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
