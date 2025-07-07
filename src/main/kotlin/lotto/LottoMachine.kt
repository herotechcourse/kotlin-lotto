package lotto

class LottoMachine() {
    fun createGeneratedTickets(
        totalPurchasedTickets: Int,
        manualTicketsQuantity: Int,
    ): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        var ticketsToBeGenerated = totalPurchasedTickets - manualTicketsQuantity
        var countGeneratedTickets = 0
        while (countGeneratedTickets < ticketsToBeGenerated) {
            lottos.add(Lotto.create())
            countGeneratedTickets++
        }

        return lottos
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
    ): Long {
        val totalPrize = calculateTotalPrize(results)
        return (totalPrize.toLong() / userAmount)
    }

    private fun calculateTotalPrize(results: MutableMap<Rank, Int>): Int {
        var totalPrize = 0
        results.forEach { (key, value) ->
            totalPrize += key.winningMoney * value
        }
        return totalPrize
    }

    fun createManualTickets(userManualTicketNumbers: List<List<Int>>): List<Lotto> {
        return userManualTicketNumbers.map { ticket -> Lotto(ticket.map { number -> LottoNumber(number) }) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
