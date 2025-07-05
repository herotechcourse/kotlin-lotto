package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class RankTest {
    @Test
    fun `should assign the corresponding rank when it has bonus`() {
        val matchingNumber = 5
        val hasBonus = true

        assertEquals(
            actual = "SECOND",
            expected = Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            message = "Should match the right rank",
        )
    }

    @Test
    fun `should assign the corresponding rank`() {
        val matchingNumber = 5
        val hasBonus = false

        assertEquals(
            actual = "THIRD",
            expected = Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            message = "Should match the right rank",
        )
    }

    @Test
    fun `should assign MISS when is not matching less than 3 numbers`() {
        val matchingNumber = 2
        val hasBonus = false

        assertEquals(
            actual = "MISS",
            expected = Rank.valueOf(countOfMatch = matchingNumber, matchBonus = hasBonus).toString(),
            message = "Should match the right rank",
        )
    }
}
