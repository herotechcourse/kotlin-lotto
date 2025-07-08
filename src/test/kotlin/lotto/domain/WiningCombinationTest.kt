package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WiningCombinationTest {
    @Test
    fun `throw if bonus number is not in range`() {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
            WinningCombination(winningNumbers, LottoNumber.from(0))
        }
    }


    @Test
    fun `throw if bonus number is not unique`() {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
            WinningCombination(winningNumbers, LottoNumber.from(2))
        }
    }

    @Test
    fun `throw if bonus number is not in range 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
            WinningCombination(winningNumbers, LottoNumber.from(100))
        }
    }

    @Test
    fun `do not throw if Winningnumbers have 6 winning numbers and bonus number`() {
        assertDoesNotThrow {
            val winningNumbers = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
            WinningCombination(winningNumbers, LottoNumber.from(7))
        }
    }
}
