package lotto.controller

import lotto.domain.LottoTicket
import lotto.domain.NumberGenerator
import lotto.dto.IssuedTickets

object TicketIssuer {

    /**
     * @param pendingTickets raw data
     */
    fun with(pendingTickets: List<Set<Int>>): IssuedTickets {
        val lottoTickets = pendingTickets.map {
            LottoTicket.from(it)
        }
        return IssuedTickets(lottoTickets)
    }

    fun issueManual(count: Int): IssuedTickets {
        return issue(count, Prompter::askManualNumbers)
    }

    fun issueRandom(count: Int): IssuedTickets {
        return issue(count) { size -> List(size) { NumberGenerator.get() } }
    }

    private fun issue(
        count: Int,
        prompter: (Int) -> List<Set<Int>>,
    ): IssuedTickets {
        return with(prompter(count))
    }
}