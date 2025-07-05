package lotto.services

import lotto.dto.IssuedTickets
import lotto.dto.PendingTickets
import lotto.factory.LottoTicketFactory

object TicketIssuer {
    fun with(pendingTickets: PendingTickets) : IssuedTickets {
        val lottoTickets = pendingTickets.requests.map {
            LottoTicketFactory.issueTicket(it.numbers)
        }
        return IssuedTickets(lottoTickets)
    }
}