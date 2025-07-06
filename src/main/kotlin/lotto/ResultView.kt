package lotto

class ResultView() {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.count()} tickets.")
        lottos.forEach { lotto ->
            val lottoNumbers = lotto.getLottoNumbersAsInt()
            println(lottoNumbers.joinToString(",", "[", "]"))
        }
    }

    fun printResult(results: MutableMap<Rank, Int>) {
        println(
            """
            
            ${PRESENT_WINNING}
            $SEPARATOR
            ${THREE_MATCHES_RESULT.format(results.getValue(Rank.FIFTH))}
            ${FOUR_MATCHES_RESULT.format(results.getValue(Rank.FOURTH))}
            ${FIVE_MATCHES_RESULT.format(results.getValue(Rank.THIRD))}
            ${FIVE_MATCHES_RESULT_WITH_BONUS.format(results.getValue(Rank.SECOND))}
            ${SIX_MATCHES_RESULT.format(results.getValue(Rank.FIRST))}
            """.trimIndent(),
        )
    }

    fun printReturnRate(rate: Double) {
        val formattedRate = String.format("%.1f", rate).replace(',', '.')
        println(PRESENT_RATE.format(formattedRate))
    }

    companion object Messages {
        const val PRESENT_WINNING = "Winning Statistics"
        const val SEPARATOR = "------------------"
        const val THREE_MATCHES_RESULT = "3 Matches (5,000 KRW) - %s tickets"
        const val FOUR_MATCHES_RESULT = "4 Matches (50,000 KRW) - %s tickets"
        const val FIVE_MATCHES_RESULT = "5 Matches (1,500,000 KRW) - %s tickets"
        const val FIVE_MATCHES_RESULT_WITH_BONUS = "5 Matches + Bonus Ball (30,000,000 KRW) - %s tickets"
        const val SIX_MATCHES_RESULT = "6 Matches (2,000,000,000 KRW) - %s tickets"
        const val PRESENT_RATE = "Total return rate is %s"
    }
}
