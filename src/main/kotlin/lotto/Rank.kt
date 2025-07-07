package lotto

enum class Rank(
    val matchCount: Int,
    val hasBonus: Boolean,
    val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0),
    ;

    companion object {
        fun of(
            matchCount: Int,
            isMatchBonusNumber: Boolean,
        ): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (isMatchBonusNumber) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }

    fun ofTicket(
        ticket: LottoTicket,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): Rank {
        val matchCount = ticket.numbers.count { winningNumbers.contains(it) }
        val hasBonus = ticket.numbers.contains(bonusNumber)
        return of(matchCount, hasBonus)
    }
}
