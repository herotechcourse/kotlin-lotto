package lotto

import kotlin.collections.shuffled

class LottoMachine(val purchaseAmount: Int, val tickets: MutableList<Lotto> = emptyList<Lotto>().toMutableList()) {
    var _change = 0
    val change: Int
        get() = _change
    private var ticketCount = 0

    init {
        require(purchaseAmount in MIN..MAX) {
            "[ERROR] Max purchase amount allowed is $MIN-$MAX."
        }
        _change = purchaseAmount % TICKET_PRICE
        ticketCount = (purchaseAmount - _change) / TICKET_PRICE
        generateTickets()
    }

    fun showChange() = _change

    fun generateTickets() {
        repeat(ticketCount) {
            tickets.add(Lotto(generateRandomNumbers()))
        }
    }

    private fun generateRandomNumbers(): List<Int> =
        (LottoNumber.MIN..LottoNumber.MAX)
            .shuffled()
            .subList(0, Lotto.LOTTO_SIZE)

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        const val TICKET_PRICE = 1_000
    }
}
