package lotto

class LottoMachine() {
    fun createTickets(userAmount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val amountOfTickets = calculateTickets(userAmount)
        var count = 0
        while (count < amountOfTickets) {
            lottos.add(Lotto.create())
            count++
        }
        return lottos
    }

    private fun calculateTickets(userAmount: Int): Int {
        val numberOfTickets = userAmount / LOTTO_PRICE
        return numberOfTickets
    }

    fun compareTickets(
        lottos: List<Lotto>,
        winningNumber: List<String>,
        bonusNumber: Int,
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()

        lottos.forEach { ticket ->
            val rank = ticket.calculateRank(winningNumber, bonusNumber)
            prizeCounter[rank] = prizeCounter.getValue(rank) + 1
        }
        return prizeCounter
    }

    private fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun calculateReturnRate(
        results: MutableMap<Rank, Int>,
        userAmount: Int,
    ): Double {
        val totalPrize = calculateTotalPrize(results)
        return (totalPrize.toDouble() / userAmount.toDouble())
    }

    private fun calculateTotalPrize(results: MutableMap<Rank, Int>): Int {
        var totalPrize = 0
        results.forEach { (key, value) ->
            totalPrize += key.winningMoney * value
        }
        return totalPrize
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
