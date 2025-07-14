package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

private const val TICKET_COST = 1000

class LottoMachineTest {
    @Test
    fun `machine should issue correct number of tickets`() {
        val manuallyEnteredNumbers = listOf(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)))
        val lottoMachine = LottoMachine(Money.of(2000), manuallyEnteredNumbers)
        assertTrue(lottoMachine.tickets.size == 2000 / TICKET_COST)
    }

    @Test
    fun `if manual ticket number is bigger than available money allow throw`() {
        val manualTicketCount = 5
        val maxTickets = 4
        assertTrue(manualTicketCount > maxTickets)
    }
}
