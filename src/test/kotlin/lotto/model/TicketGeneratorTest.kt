package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketGeneratorTest {
    @Test
    fun `generate the right number of tickets`() {
        val numberOfTickets = 6
        val tickets = TicketGenerator.generateAutomaticTickets(numberOfTickets)
        assertThat(tickets).hasSize(numberOfTickets)
    }

    // generate manual tickets
    @Test
    fun `should generate list of Lotto from list of manual ticket sets`() {
        val manualTicketsList =
            listOf(
                setOf(1, 2, 3, 4, 5, 6),
                setOf(10, 11, 12, 13, 14, 15),
            )

        val result = TicketGenerator.generateManualTickets(manualTicketsList)

        assertThat(result).hasSize(2)

        val expectedFirst = setOf(1, 2, 3, 4, 5, 6).map(LottoNumber::from).toSet()
        val expectedSecond = setOf(10, 11, 12, 13, 14, 15).map(LottoNumber::from).toSet()

        assertThat(result[0].lottoNumbers).isEqualTo(expectedFirst)
        assertThat(result[1].lottoNumbers).isEqualTo(expectedSecond)
    }
}
