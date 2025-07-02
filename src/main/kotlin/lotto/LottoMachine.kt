package lotto

class LottoMachine(val userAmount: Int) {
    private fun calculateTickets(): Int {
        val numberOfTickets = userAmount / 1000
        return numberOfTickets
    }

    private fun generateNumbers(): List<Int> {
        val randomNumbers = (1..45).shuffled().take(6).sorted()
        return randomNumbers
    }

    fun createTickets(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val amountOfTickets = calculateTickets()
        var count = 0
        while (count < amountOfTickets) {
            val lotto = Lotto(generateNumbers())
            lottos.add(lotto)
            count++
        }
        return lottos
    }

    fun compareTicketToWinningNumbers(
        lotto: Lotto,
        winningNumbers: List<String>,
    ): Int {
        var countMatches = 0
        winningNumbers.forEach { number ->
            if (number.toInt() in lotto.getNumbers()) {
                countMatches++
            }
        }
        return countMatches
    }

    fun compareTicketToBonusNumber(
        lotto: Lotto,
        bonusNumber: Int,
    ): Boolean {
        return bonusNumber in lotto.getNumbers()
    }

    fun createMap(): MutableMap<Rank, Int> {
        val prizeCounter = mutableMapOf<Rank, Int>()
        for (rank in Rank.values()) {
            prizeCounter[rank] = 0
        }
        return prizeCounter
    }

    fun compareTickets(
        lottos: List<Lotto>,
        winningNumber: List<String>,
        bonusNumber: Int,
    ): MutableMap<Rank, Int> {
        val prizeCounter = createMap()

        lottos.forEach { ticket ->
            var hasBonus = false

            val matches = compareTicketToWinningNumbers(ticket, winningNumber)
            if (matches == 5) {
                hasBonus = compareTicketToBonusNumber(ticket, bonusNumber)
            }
            val chosen = Rank.valueOf(matches, hasBonus)
            prizeCounter[chosen] = prizeCounter.getValue(chosen) + 1
        }
        return prizeCounter
    }

    fun calculateTotalPrize(results: MutableMap<Rank, Int>): Int {
        var totalPrize = 0
        results.forEach { (key, value) ->
            totalPrize += key.winningMoney * value
        }
        return totalPrize
    }

    fun calculateReturnRate(
        results: MutableMap<Rank, Int>,
        userAmount: Int,
    ): Double {
        val totalPrize = calculateTotalPrize(results)
        return (totalPrize.toDouble() / userAmount.toDouble())
    }
}
