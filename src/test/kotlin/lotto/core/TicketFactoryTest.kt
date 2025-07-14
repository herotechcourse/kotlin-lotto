package lotto.core

import lotto.model.TicketFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketFactoryTest {
    val ticketFactory = TicketFactory

    //  calculate number of tickets
    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000])
    fun `calculate the right number of tickets`(purchaseAmounts: Int) {
        val rightNumberOfTickets = purchaseAmounts / 1000
        val numberOfTickets = ticketFactory.calculateNumberOfTickets(purchaseAmounts)
        assertThat(rightNumberOfTickets).isEqualTo(numberOfTickets)
    }

    @Test
    fun `Should throw exception if purchase Amount is negative`() {
        val purchaseAmount = -10
        assertThrows<IllegalArgumentException> {
            ticketFactory.calculateNumberOfTickets(purchaseAmount)
        }
    }
}
