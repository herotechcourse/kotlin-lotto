package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {
    @Test
    fun `should throw when lotto ticket has insufficient numbers`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(hashSetOf())
        }
    }
}