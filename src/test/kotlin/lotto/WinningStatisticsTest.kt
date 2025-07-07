package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `should return correct return rate for 1 FIFTH prize`() {
        val tempTable = mutableListOf(0, 0, 0, 0, 1, 0) // FIFTH at index 4
        val amountSpent = 1000

        val winningMoney = WinStatCalculator.calculateWinningMoney(tempTable)
        val returnRate = WinStatCalculator.calculateReturnRate(winningMoney, amountSpent)

        println(returnRate)
        assertEquals(5.0, returnRate, 0.0001)
    }
}
