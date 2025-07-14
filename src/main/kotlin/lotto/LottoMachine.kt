package lotto

import java.math.BigDecimal

class LottoMachine() {
    fun createGeneratedTickets(
        totalPurchasedTickets: Int,
        manualTicketsQuantity: Int,
    ): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val ticketsToBeGenerated = totalPurchasedTickets - manualTicketsQuantity
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
    ): BigDecimal {
        val totalPrize = calculateTotalPrize(results)
        val rate = (totalPrize / userAmount.toBigDecimal())
        return rate
    }

    private fun calculateTotalPrize(results: MutableMap<Rank, Int>): BigDecimal {
        var totalPrize = 0.toBigDecimal()
        results.forEach { (key, value) ->
            totalPrize += key.winningMoney.toBigDecimal() * value.toBigDecimal()
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
