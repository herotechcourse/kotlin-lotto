package lotto.factory

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object LottoTicketFactory {
    fun issueTicket(numbers: Set<Int>): LottoTicket {
        return LottoTicket(numbers.map { LottoNumber.from(it) }.toHashSet())
    }

    fun issueTickets(listOfNumbers: List<Set<Int>>): List<LottoTicket> {
        return listOfNumbers.map {
            issueTicket(it)
        }
    }
}