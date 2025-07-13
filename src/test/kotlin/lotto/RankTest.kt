package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `Check Rank returns Second when bonus number is true with matchCount = 5`() {
        assertEquals(Rank.valueOf(5, true), Rank.SECOND)
    }

    @Test
    fun `Check Rank returns Third when bonus number is false with matchCount = 5`() {
        assertEquals(Rank.valueOf(5, false), Rank.THIRD)
    }

    @Test
    fun `Check Rank returns FOURTH when bonus number is false with matchCount = 5`() {
        assertEquals(Rank.valueOf(4, false), Rank.FOURTH)
    }
}
