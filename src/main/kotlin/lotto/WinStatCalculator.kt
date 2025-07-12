package lotto

class WinStatCalculator {
    fun calculateWinningMoney(statistics: WinningStatistics): Int {
        return Rank.entries
            .filter { it != Rank.MISS }
            .sumOf { rank -> statistics.countOf(rank) * rank.prize }
    }

    fun calculateReturnRate(
        winningMoney: Int,
        amountOfMoney: Int,
    ): Double {
        return if (amountOfMoney == 0) {
            0.0
        } else {
            winningMoney.toDouble() / amountOfMoney
        }
    }
}
