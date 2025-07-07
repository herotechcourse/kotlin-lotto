package lotto

import io.kotest.matchers.collections.shouldNotContainDuplicates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketTest {
    private val validNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `The cost of a ticket is 1000 KRW`() {
        val ticket = LottoTicket(validNumbers)
        assertEquals(LottoTicket.COST_OF_TICKET, ticket.cost)
    }

    @Test
    fun `Ticket has 6 Int numbers in array`() {
        val ticket = LottoTicket(validNumbers)
        assertEquals(LottoTicket.SIZE_OF_NUMBERS, ticket.numbers.size)
    }

    @Test
    fun `Ticket number should be from 1-45`() {
        val ticket = LottoTicket(validNumbers)
        ticket.numbers.forEach {
            require(it in 1..45)
        }
    }

    @Test
    fun `Ticket numbers are not duplicated`() {
        val ticket = LottoTicket(validNumbers)
        ticket.numbers.shouldNotContainDuplicates()
    }
}
