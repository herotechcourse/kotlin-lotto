package lotto

class WinningStatistics(
    private val rankCounts: Map<Rank, Int>,
) {
    fun countOf(rank: Rank): Int {
        return rankCounts.getOrDefault(rank, 0)
    }

    fun asMap(): Map<Rank, Int> {
        return rankCounts
    }
}
