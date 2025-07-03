package lotto

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
}
