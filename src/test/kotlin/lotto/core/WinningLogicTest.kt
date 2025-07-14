package lotto.core

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Rank
import lotto.model.WinningLogic
import lotto.model.WinningLotto
import lotto.model.WinningLottoFactory
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class WinningLogicTest {
    @Test
    fun `calculate right number of Ranks`() {
        val winningLotto = WinningLotto(Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6)), LottoNumber.from(9))
        val ticket1 = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6))
        val ticket2 = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 9))
        val ticket3 = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 8))
        val ticket5 = Lotto.fromInts(setOf<Int>(1, 2, 3, 8, 10, 9))
        val ticket6 = Lotto.fromInts(setOf<Int>(1, 2, 10, 11, 12, 9))
        val ticket4 = Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 8, 10))
        val tickets = listOf<Lotto>(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6)
        val result = WinningLogic.determineWinningTickets(tickets, winningLotto)

        assertThat(result.count(Rank.FIRST)).isEqualTo(1)
        assertThat(result.count(Rank.SECOND)).isEqualTo(1)
        assertThat(result.count(Rank.THIRD)).isEqualTo(1)
        assertThat(result.count(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.count(Rank.FIFTH)).isEqualTo(1)
        assertThat(result.count(Rank.MISS)).isEqualTo(1)
    }

    @Test
    fun `generate right winning Lotto`() {
        val winningNumbers = setOf<Int>(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)
        val expectedWinningLotto = WinningLotto(Lotto.fromInts(setOf<Int>(1, 2, 3, 4, 5, 6)), bonusNumber)

        val actualWinningLotto =
            WinningLottoFactory.from(
                listOfInt = winningNumbers,
                bonusNumber = bonusNumber,
            )
        assertThat(expectedWinningLotto).isEqualTo(actualWinningLotto)
    }
}
