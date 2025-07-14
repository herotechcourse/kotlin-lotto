package lotto.model

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class LottoResultTest {
    @Test
    fun `should calculate total prize correctly`() {
        val result =
            mapOf(
                Rank.FIRST to 1,
                Rank.THIRD to 2,
                Rank.MISS to 5,
            )
        val lottoResult = LottoResult(result, ticketsCount = 8)
        val expectedPrize = Rank.FIRST.winningMoney + 2 * Rank.THIRD.winningMoney

        assertThat(lottoResult.calculateTotalPrize()).isEqualTo(expectedPrize)
    }

    @Test
    fun `should calculate profit rate correctly`() {
        val totalPrizes = mapOf(Rank.FIFTH to 1)
        val ticketsCount = 8
        val lottoResult = LottoResult(totalPrizes, ticketsCount)

        val expectedProfitRate = 5_000.0 / 8000
        assertThat(lottoResult.calculateProfitRate()).isEqualTo(expectedProfitRate)
    }

    @Test
    fun `should return 0 profit rate when no prize is won`() {
        val result = mapOf(Rank.MISS to 10)
        val lottoResult = LottoResult(result, ticketsCount = 10)
        assertThat(lottoResult.calculateProfitRate()).isEqualTo(0.0)
    }

    @Test
    fun `should return correct count of specific prize`() {
        val result =
            mapOf(
                Rank.SECOND to 1,
                Rank.FIFTH to 2,
            )
        val lottoResult = LottoResult(result, ticketsCount = 3)

        assertThat(lottoResult.count(Rank.SECOND)).isEqualTo(1)
        assertThat(lottoResult.count(Rank.FIFTH)).isEqualTo(2)
        assertThat(lottoResult.count(Rank.FIRST)).isEqualTo(0)
    }
}
