package lotto.model

class WinningStatistics() {
    var winningMoney: Int = 0
    var returnRate: Double = 0.0

    fun calculateWinningMoney(resultTable: MutableList<Int>): Int {
        var result: Int = 0
        result += resultTable[1] * Rank.FIRST.prize
        result += resultTable[2] * Rank.SECOND.prize
        result += resultTable[3] * Rank.THIRD.prize
        result += resultTable[4] * Rank.FOURTH.prize
        result += resultTable[5] * Rank.FIFTH.prize
        winningMoney = result
        return result
    }

    fun calculateReturnRate(amountOfMoney: Int): Double {
        val result: Double = winningMoney.toDouble() / amountOfMoney.toDouble()
        returnRate = result
        return result
    }
}
