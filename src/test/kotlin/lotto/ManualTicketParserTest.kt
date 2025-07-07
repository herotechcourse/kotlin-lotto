package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ManualTicketParserTest {
    @Test
    fun `parses valid ticket correctly`() {
        val line = "1, 2, 3, 4, 5, 6"
        val ticket = ManualTicketParser.parse(line)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), ticket.numbers)
    }

    @Test
    fun `throws on duplicate numbers`() {
        val line = "1, 2, 3, 3, 4, 5"
        assertThrows(IllegalArgumentException::class.java) {
            ManualTicketParser.parse(line)
        }
    }

    @Test
    fun `throws on out of range number`() {
        val line = "1, 2, 3, 4, 5, 46"
        assertThrows(IllegalArgumentException::class.java) {
            ManualTicketParser.parse(line)
        }
    }

    @Test
    fun `throws on non-number`() {
        val line = "1, 2, x, 4, 5, 6"
        assertThrows(IllegalArgumentException::class.java) {
            ManualTicketParser.parse(line)
        }
    }
}
