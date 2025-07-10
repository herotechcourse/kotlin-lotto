package lotto.model

class Tickets(val tickets: List<LottoTicket> = emptyList()) {
    fun contains(ticket: LottoTicket): Boolean = tickets.contains(ticket)

    fun asList(): List<LottoTicket> = tickets.toList()
}
