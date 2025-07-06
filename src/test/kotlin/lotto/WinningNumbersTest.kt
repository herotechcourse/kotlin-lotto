package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @Test
    fun `Bonus number different than winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> { WinningNumbers(lotto, 5) }
    }

    @ParameterizedTest
    @ValueSource(ints = [51, -1])
    fun `Bonus number in range 0 and 50`(bonusNumber: Int) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> { WinningNumbers(lotto, bonusNumber) }
    }
}
