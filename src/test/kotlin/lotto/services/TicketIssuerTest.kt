package lotto.services

import lotto.dto.IssuedTickets
import lotto.dto.PendingTicket
import lotto.dto.PendingTickets
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketIssuerTest {
    @Test
    fun `throw if can not issue ticket`() {
        assertThrows<IllegalArgumentException> {
            val pendingTickets = PendingTickets(listOf(PendingTicket(setOf(0, 1, 2, 3, 4, 5, 6))))
            val issuedTickets: IssuedTickets = TicketIssuer.with(pendingTickets)
        }
    }
}