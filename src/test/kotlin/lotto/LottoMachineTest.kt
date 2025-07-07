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
                amountOfMoney = 2000,
                lastWeekWinningNumbers = winningNumbers,
                bonusNumber = bonusNumber,
            )

        machine.bundleOfLottoTicket =
            listOf(
                LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
                // second
                LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
            )

        machine.writeResultTable()

        assertEquals(1, machine.resultTable[Rank.FIRST])
        assertEquals(1, machine.resultTable[Rank.SECOND])
    }
}
