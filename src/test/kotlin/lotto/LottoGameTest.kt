package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `should correctly count winning tickets`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val tickets =
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 45)),
                Lotto(listOf(1, 2, 3, 4, 44, 45)),
                Lotto(listOf(1, 2, 3, 43, 44, 45)),
                Lotto(listOf(10, 11, 12, 13, 14, 15)),
            )
        val game = LottoGame()
        val result = game.play(tickets, winningNumbers, LottoNumber.from(bonusNumber))
        assertEquals(1, result.find { it.rank == Rank.FIRST }?.ticketsCount)
        assertEquals(1, result.find { it.rank == Rank.SECOND }?.ticketsCount)
        assertEquals(1, result.find { it.rank == Rank.THIRD }?.ticketsCount)
        assertEquals(1, result.find { it.rank == Rank.FOURTH }?.ticketsCount)
        assertEquals(1, result.find { it.rank == Rank.FIFTH }?.ticketsCount)
        assertEquals(1, result.find { it.rank == Rank.NONE }?.ticketsCount)
    }

    @Test
    fun `should correct count winning amount`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val tickets =
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 45)),
                Lotto(listOf(1, 2, 3, 4, 44, 45)),
                Lotto(listOf(1, 2, 3, 43, 44, 45)),
                Lotto(listOf(10, 11, 12, 13, 14, 15)),
            )
        val game = LottoGame()
        val result = game.play(tickets, winningNumbers, LottoNumber.from(bonusNumber))
        val winningAmount = game.countWinningAmount(result)
        assertEquals(winningAmount, 2_031_555_000)
    }
}
