package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `Bonus number different than winning numbers`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(5)
        assertThrows<IllegalArgumentException> { WinningNumbers(lotto, bonusNumber) }
    }
}
