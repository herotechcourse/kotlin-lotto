package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `should return correct return rate for 1 FIFTH prize`() {
        val tempTable = WinningStatistics(mapOf(Rank.FIFTH to 1))
        val amountSpent = 1000

        val winStatCalculator = WinStatCalculator()
        val winningMoney = winStatCalculator.calculateWinningMoney(tempTable)
        val returnRate = winStatCalculator.calculateReturnRate(winningMoney, amountSpent)

        println(returnRate)
        assertEquals(5.0, returnRate, 0.0001)
    }
}
