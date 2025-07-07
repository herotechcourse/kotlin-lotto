package lotto

import kotlin.collections.shuffled

class LottoMachine(val purchaseAmount: Int, val tickets: MutableList<Lotto> = mutableListOf<Lotto>()) {
    val change = purchaseAmount % TICKET_PRICE
    private val ticketCount = (purchaseAmount - change) / TICKET_PRICE

    init {
        require(purchaseAmount in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
        generateTickets()
    }

    fun generateTickets() {
        repeat(ticketCount) {
            tickets.add(Lotto.from(generateRandomNumbers()))
        }
    }

    private fun generateRandomNumbers(): List<Int> =
        (LottoNumber.MIN..LottoNumber.MAX)
            .shuffled()
            .subList(0, Lotto.LOTTO_SIZE)
            .sorted()

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        const val TICKET_PRICE = 1_000
    }
}
