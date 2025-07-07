package lotto

data class RankResult(
    val rank: Rank,
) {
    var ticketsCount = 1
        private set

    fun increaseTicketsCount() {
        ticketsCount++
    }
}
