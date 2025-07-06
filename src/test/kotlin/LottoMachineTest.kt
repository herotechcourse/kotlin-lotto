package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `should return right amount of tickets`() {
        val lottoMachine = LottoMachine()
        val userAmount = lottoMachine.createTickets(5000).count()
        val actual = 5
        assertEquals(
            actual,
            userAmount,
            "Amount isn't a multiple of 1000",
        )
    }

    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(1000)
        val numbersInTicket = tickets[0].getLottoNumbersAsInt()
        assertEquals(
            6,
            numbersInTicket.count(),
            "Ticket numbers aren't 6",
        )
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        assertEquals(
            4,
            lottoMachine.createTickets(4000).count(),
            "Amount of tickets is different then expected",
        )
    }

    @Test
    fun `correct amount of rate is calculated`() {
        val lottoMachine = LottoMachine()
        val results = mutableMapOf<Rank, Int>()
        results[Rank.FIFTH] = 1
        val amount = 3000
        assertEquals(
            lottoMachine.calculateReturnRate(results, amount),
            1.6666666666666667,
            "Rate result is different than expected",
        )
    }
}
