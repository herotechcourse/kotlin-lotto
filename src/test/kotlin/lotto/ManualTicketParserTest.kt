package lotto

import io.kotest.core.spec.style.AnnotationSpec.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ManualTicketParserTest {
    @BeforeEach
    val manualTicketParser = ManualTicketParser()

    @Test
    fun `parses valid ticket correctly`() {
        val line = "1, 2, 3, 4, 5, 6"
        val ticket = manualTicketParser.parse(line)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), ticket.numbers)
    }

    @Test
    fun `throws on duplicate numbers`() {
        val line = "1, 2, 3, 3, 4, 5"
        assertThrows(IllegalArgumentException::class.java) {
            manualTicketParser.parse(line)
        }
    }

    @Test
    fun `throws on out of range number`() {
        val line = "1, 2, 3, 4, 5, 46"
        assertThrows(IllegalArgumentException::class.java) {
            manualTicketParser.parse(line)
        }
    }

    @Test
    fun `throws on non-number`() {
        val line = "1, 2, x, 4, 5, 6"
        assertThrows(IllegalArgumentException::class.java) {
            manualTicketParser.parse(line)
        }
    }
}
