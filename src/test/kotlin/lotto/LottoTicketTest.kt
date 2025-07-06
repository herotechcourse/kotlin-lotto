package lotto

import io.kotest.matchers.collections.shouldNotContainDuplicates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `Ticket number should be from 1-45`() {
        val ticket = LottoTicket()
        ticket.numbers.forEach {
            require(it >= LottoTicket.MIN_LOTTO_NUMBER)
            require(it <= LottoTicket.MAX_LOTTO_NUMBER)
        }
    }

    // Minor refactoring required
    @Test
    fun `Ticket numbers are not duplicated`() {
        val ticket = LottoTicket()
        ticket.numbers.shouldNotContainDuplicates()
    }

    @Test
    fun `Throws an exception if lotto numbers size exceeds desired size`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    @Test
    fun `Throws an exception if lotto numbers size small than desired size`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    @Test
    fun `Throws an exception when lotto numbers contain number exceeds maximum limit`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    @Test
    fun `Throws an exception when lotto numbers contain number smaller than minimum limit`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 0)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }
}
