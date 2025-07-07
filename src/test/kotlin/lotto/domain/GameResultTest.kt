package lotto.domain

import lotto.domain.GameResult
import lotto.services.TicketIssuer
import lotto.services.TicketsEvaluator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GameResultTest {

    @Test
    fun `total rate is correct`() {
        assertDoesNotThrow {
            val totalIssuedTickets = TicketIssuer.with(
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(7, 8, 9, 10, 11, 12),
                    setOf(13, 14, 15, 16, 17, 18)
                )
            )
            val totalAmount = totalIssuedTickets.size() * LottoTicket.PRICE_OF_TICKET
            val winningCombination = WinningCombination(
                LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
            )

            val rankOfTicket = TicketsEvaluator.runWith(totalIssuedTickets, winningCombination)
            val returnRate = TicketsEvaluator.getTotalRate(rankOfTicket, totalAmount)
            val result = GameResult(totalIssuedTickets, winningCombination, totalAmount, rankOfTicket, returnRate)

            val totalPrize = Rank.FIRST.winningMoney
            val shouldBe = (totalPrize.toDouble() / totalAmount) * 100.0
            println("result is: ${result.returnRate}, format: ${"%.2f".format(result.returnRate)}")

            Assertions.assertThat(result.returnRate).isEqualTo(shouldBe)

        }
    }
}