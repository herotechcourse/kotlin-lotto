package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `should assign the corresponding rank when it has bonus`() {
        val matchingNumber = 5
        val hasBonus = true

        assertEquals(
            "SECOND",
            Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            "Should match the right rank",
        )
    }

    @Test
    fun `should assign the corresponding rank`() {
        val matchingNumber = 5
        val hasBonus = false

        assertEquals(
            "THIRD",
            Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            "Should match the right rank",
        )
    }

    @Test
    fun `should assign MISS when is not matching less than 3 numbers`() {
        val matchingNumber = 2
        val hasBonus = false

        assertEquals(
            "MISS",
            Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            "Should match the right rank",
        )
    }
}
