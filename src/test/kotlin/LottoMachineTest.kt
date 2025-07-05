package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine()
        assertEquals(actual = 5, expected = lottoMachine.createTickets(5000).count(), message = "Amount isn't a multiple of 1000")
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(1000)
        val numbersInTicket = tickets[0].getNumbers()
        assertEquals(actual = 6, expected = numbersInTicket.count(), message = "Ticket numbers aren't 6")
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        assertEquals(
            actual = 4,
            expected = lottoMachine.createTickets(4000).count(),
            message = "Amount of tickets is different then expected",
        )
    }

    @Test
    fun `correct amount of rate is calculated`() {
        val lottoMachine = LottoMachine()
        val results = mutableMapOf<Rank, Int>()
        results[Rank.FIFTH] = 1
        val amount = 3000
        assertEquals(
            actual = lottoMachine.calculateReturnRate(results, amount),
            expected = 1.66666666666667,
            message = "Rate result is different than expected",
        )
    }
}
