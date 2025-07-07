package lotto

object WinStatCalculator {
    fun calculateWinningMoney(resultTable: Map<Rank, Int>): Int {
        return Rank.entries
            .filter { it != Rank.MISS }
            .sumOf { rank -> resultTable.getOrDefault(rank, 0) * rank.prize }
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
