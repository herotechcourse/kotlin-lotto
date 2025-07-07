package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchasedTicketsNumberTest {
    @Test
    fun `if number of manuel tickets is not in range from 0 to number of purchased tickets`() {
        assertThrows<IllegalArgumentException> {
            PurchasedTicketsNumber(10, Money(8000))
        }
    }

    @Test
    fun `if number of manuel tickets is not in range from 0 to number of purchased tickets 2`() {
        assertThrows<IllegalArgumentException> {
            PurchasedTicketsNumber(-10, Money(8000))
        }
    }
}
