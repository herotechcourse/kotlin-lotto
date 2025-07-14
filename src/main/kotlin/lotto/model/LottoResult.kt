package lotto.model

class LottoResult(
    private val result: Map<Rank, Int>,
    private val ticketsCount: Int,
) {
    init {
        require(ticketsCount > 0)
    }

    fun calculateProfitRate(): Double {
        val purchaseAmount = ticketsCount * 1000
        return calculateTotalPrize().toDouble() / purchaseAmount
    }

    fun calculateTotalPrize(): Int {
        return result.entries.sumOf { (rank, count) ->
            rank.winningMoney * count
        }
    }

    fun count(prize: Rank) = result.getOrDefault(prize, 0)
}
