package lotto

import lotto.LottoMachine.Companion.LOTTO_PRICE

class TotalTicketsCalculator {
    fun calculateTickets(userAmount: Int): Int {
        val numberOfTickets = userAmount / LOTTO_PRICE
        return numberOfTickets
    }
}
