package lotto.services

import lotto.controller.TicketIssuer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TicketIssuerTest {
    @Test
    fun `throw if can not issue ticket`() {
        assertThrows<IllegalArgumentException> {
            val requests =
                listOf(
                    setOf(0, 1, 2, 3, 4, 5, 6),
                    setOf(46, 45, 44, 43, 42, 41),
                )
            TicketIssuer.with(requests)
        }
    }

    @Test
    fun `dose not throw if issue ticket`() {
        assertDoesNotThrow {
            val requests =
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(45, 44, 43, 42, 41, 40),
                )
            TicketIssuer.with(requests)
        }
    }
}
