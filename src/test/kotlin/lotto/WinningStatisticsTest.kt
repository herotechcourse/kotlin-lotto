package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `should return correct return rate for 1 FIFTH prize`() {
        val tempTable = mutableMapOf(Rank.FIFTH to 1)
        val amountSpent = 1000

        val winningMoney = WinStatCalculator.calculateWinningMoney(tempTable)
        val returnRate = WinStatCalculator.calculateReturnRate(winningMoney, amountSpent)

        println(returnRate)
        assertEquals(5.0, returnRate, 0.0001)
    }
}
