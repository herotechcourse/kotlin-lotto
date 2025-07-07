package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketTest {
    val testNumbers = Numbers(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `The cost of a ticket is 1000 KRW`() {
        val ticket = LottoTicket(testNumbers)
        assertEquals(LottoTicket.COST_OF_TICKET, ticket.cost)
    }

    @Test
    fun `Ticket has 6 Int numbers in array`() {
        val ticket = LottoTicket(testNumbers)
        assertEquals(LottoTicket.SIZE_OF_NUMBERS, ticket.numbers.size)
    }

    @Test
    fun `Ticket number should be from 1-45`() {
        val ticket = LottoTicket(testNumbers)
        ticket.numbers.forEach {
            require(it >= LottoTicket.MIN_LOTTO_NUMBER)
            require(it <= LottoTicket.MAX_LOTTO_NUMBER)
        }
    }
}
