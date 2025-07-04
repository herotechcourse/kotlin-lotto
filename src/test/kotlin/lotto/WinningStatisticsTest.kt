package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `should return division result()`() {
        val tempTable = mutableListOf<Int>(5, 0, 0, 0, 0, 1)
        val winStat = WinningStatistics()
        winStat.calculateWinningMoney(tempTable)
        winStat.calculateReturnRate(14000)
        assertEquals(5000.0 / 14000.0, winStat.returnRate)
    }
}
