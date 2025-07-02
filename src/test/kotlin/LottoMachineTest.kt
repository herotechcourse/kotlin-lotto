package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine(5000)
        assertEquals("Amount isn't a multiple of 1000", lottoMachine.createTickets().count(), 5)
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine(1000)
        val tickets = lottoMachine.createTickets()
        val numbersInTicket = tickets[0].getNumbers()

        assertEquals("Ticket numbers aren't 6", numbersInTicket.count(), 6)
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine(4000)
        assertEquals("Amount of tickets is different then expected", lottoMachine.createTickets().count(), 4)
    }
}
