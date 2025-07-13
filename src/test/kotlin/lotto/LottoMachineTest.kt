package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `machine should issue 2 tickets`() {
        val tickets = LottoMachine().issueTickets(1) { getListOfNumbers() }
        assertTrue(tickets.size == 1)
    }

    private fun getListOfNumbers(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
