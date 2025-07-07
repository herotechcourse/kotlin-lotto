package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `machine should issue 2 tickets`() {
        val lottoMachine =
            LottoMachine(
                PurchasedTicketsNumber(
                    0,
                    Money(2000),
                ),
            )
        assertTrue(lottoMachine.tickets.size == 2000 / TICKET_PRICE)
    }
}
