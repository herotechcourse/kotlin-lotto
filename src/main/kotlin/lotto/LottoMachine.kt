package lotto

import kotlin.collections.shuffled

class LottoMachine(val purchase: Purchase, val tickets: MutableList<Lotto> = mutableListOf<Lotto>()) {
    private val ticketCount = purchase.ticketCount

    init {
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

    }
}
