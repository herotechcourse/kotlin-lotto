package lotto.dto

import lotto.domain.LottoTicket

data class IssuedTickets(private val tickets: List<LottoTicket>) {
    fun size() = tickets.size
    fun all(): List<LottoTicket> = tickets
}