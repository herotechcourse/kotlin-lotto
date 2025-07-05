package lotto.factory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketMachineTest {

    @Test
    fun `should throw when can not issue ticket`() {
        assertThrows<IllegalArgumentException> {
            val lottoTicket1 = TicketMachine.issueTicket(setOf())
            val lottoTicket2 = TicketMachine.issueTicket(setOf(0, 1, 2, 3, 4, 5))
        }
    }
}
