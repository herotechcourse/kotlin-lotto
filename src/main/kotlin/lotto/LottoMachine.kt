package lotto

import kotlin.collections.shuffled

class LottoMachine() {
    fun generateTickets(ticketCount: Int): List<Lotto> {
        val tickets: MutableList<Lotto> = mutableListOf()
        repeat(ticketCount) {
            tickets.add(Lotto.from(generateRandomNumbers()))
        }
        return tickets
    }

    private fun generateRandomNumbers(): List<Int> =
        (LottoNumber.MIN..LottoNumber.MAX)
            .shuffled()
            .subList(0, Lotto.LOTTO_SIZE)
            .sorted()

    companion object {

    }
}
