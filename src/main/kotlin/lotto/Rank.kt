package lotto

enum class Rank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prizeAmount: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0), ;

    companion object {
        fun getRank(
            matchCount: Int,
            matchBonus: Boolean,
        ): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}
