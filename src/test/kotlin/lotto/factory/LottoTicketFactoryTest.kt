package lotto.factory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTicketFactoryTest {

    @Test
    fun `throw when can not issue ticket`() {
        assertThrows<IllegalArgumentException> {
            val lottoTicket1 = LottoTicketFactory.issueTicket(setOf())
            val lottoTicket2 = LottoTicketFactory.issueTicket(setOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `dose not throw when can not issue ticket`() {
        assertDoesNotThrow {
            val lottoTicket1 = LottoTicketFactory.issueTicket(setOf(1,2,3,4,5,6))
            val lottoTicket2 = LottoTicketFactory.issueTicket(setOf(45,44,43,42,41,40))
        }
    }
}
