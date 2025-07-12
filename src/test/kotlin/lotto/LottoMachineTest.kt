package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `LottoMachine correctly filters ranks`() {
        val machine =
            LottoMachine(
                winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                bonusNumber = BonusNumber(7),
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
