package lotto.services

import lotto.domain.LottoTicket
import lotto.dto.IssuedTickets

object TicketIssuer {
    fun with(pendingTickets: List<Set<Int>>): IssuedTickets {
        val lottoTickets = pendingTickets.map {
            LottoTicket.from(it)
        }
        return IssuedTickets(lottoTickets)
    }
}