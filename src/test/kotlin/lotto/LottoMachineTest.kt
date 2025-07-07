package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `LottoMachine correctly filters ranks`() {
        val machine =
            LottoMachine(
                lastWeekWinningNumbers = winningNumbers,
                bonusNumber = bonusNumber,
            )

        val tickets =
            listOf(
                LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
                LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
            )

        val resultTable = machine.createResultTable(tickets)

        assertEquals(1, resultTable[Rank.FIRST])
        assertEquals(1, resultTable[Rank.SECOND])
    }
}
