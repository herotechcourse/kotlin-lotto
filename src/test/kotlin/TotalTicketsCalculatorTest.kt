package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalTicketsCalculatorTest {
    @Test
    fun `should return right amount of tickets`() {
        val totalTicketsCalculator = TotalTicketsCalculator()
        val userAmount = totalTicketsCalculator.calculateTickets(5000)
        val expected = 5
        assertEquals(
            expected,
            userAmount,
            "Amount isn't a multiple of 1000",
        )
    }
}
