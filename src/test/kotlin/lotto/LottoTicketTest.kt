package lotto

import io.kotest.matchers.collections.shouldNotContainDuplicates
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoTicketTest {

    @Test
    fun `The cost of a ticket is 1000 KRW`() {
        val ticket = LottoTicket()
        assertEquals(LottoTicket.COST_OF_TICKET, ticket.cost)
    }

    @Test
    fun `Ticket has 6 Int numbers in array`() {
        val ticket = LottoTicket()
        assertEquals(LottoTicket.SIZE_OF_NUMBERS, ticket.numbers.size)
    }

    // Lots of refactoring required
    @Test
    fun `Ticket number should be from 1-45`() {
        val ticket = LottoTicket()
        ticket.numbers.forEach {
            require(it > 0)
            require(it < 46)
        }
    }

    // Minor refactoring required
    @Test
    fun `Ticket numbers are not duplicated`() {
        val ticket = LottoTicket()
        ticket.numbers.shouldNotContainDuplicates()
    }
}