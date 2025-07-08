package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {
    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 21000])
    fun `Purchase amount should be minimum 1_000 and (maximum 20_000 KRW)`(number: Int) {
        assertThrows<IllegalArgumentException> { Purchase(number) }
    }

    @Test
    fun `Change is calculated for the User`() {
        val purchase = Purchase(1234)
        assertEquals(purchase.change, 234)
    }

    @ParameterizedTest
    @ValueSource(ints = [1_000, 20_000])
    fun `Generates correct number of tickets as a list`(amount: Int) {
        val purchase = Purchase(amount)
        assertEquals(purchase.ticketCount, amount / Purchase.TICKET_PRICE)
    }
}
