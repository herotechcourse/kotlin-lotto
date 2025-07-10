package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {
    @Test
    fun `Change is calculated for the User`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(0)

        val machine = LottoMachine(purchaseAmount, enteredTicketCount)
        assertEquals(machine.change, 876)
    }

    @ParameterizedTest
    @ValueSource(ints = [20_000])
    fun `Generates correct number of tickets as a list`(amount: Int) {
        val purchaseAmount = PurchaseAmount(amount)
        val enteredTicketCount = EnteredTicketCount(0)

        val machine = LottoMachine(purchaseAmount, enteredTicketCount)

        assertEquals(machine.tickets.size, amount / LottoMachine.TICKET_PRICE)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 4, 9])
    fun `Entered Ticket count is less than equal too Purchasable tickets`(number: Int) {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(number)
        assertEquals(
            LottoMachine(purchaseAmount, enteredTicketCount).purchaseAmount,
            purchaseAmount,
        )
    }

    @Test
    fun `Entered Ticket count should be less than Purchasable tickets`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(10)
        assertThrows<IllegalArgumentException> {
            LottoMachine(purchaseAmount, enteredTicketCount).purchaseAmount
        }
    }

    @Test
    fun `Generated ticket count is correct`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(4)
        assertEquals(
            LottoMachine(purchaseAmount, enteredTicketCount).generatedTicketCount,
            5,
        )
    }
}
