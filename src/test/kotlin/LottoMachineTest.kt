package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(1, 0)
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
            2,
            lottoMachine.createTickets(4, 2).count(),
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
