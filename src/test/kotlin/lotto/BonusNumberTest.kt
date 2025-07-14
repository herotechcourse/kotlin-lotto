package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `should create BonusNumber when number in range and not in lotto numbers`() {
        val primaryNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonus = BonusNumber.of(7, primaryNumbers)
        assertThat(bonus.number).isEqualTo(7)
    }

    @Test
    fun `if bonus number is out of range throw`() {
        val primaryNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            BonusNumber.of(0, primaryNumbers)
        }
        assertThrows<IllegalArgumentException> {
            BonusNumber.of(46, primaryNumbers)
        }
    }

    @Test
    fun `if bonus number is in primary lotto numbers throw`() {
        val primaryNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            BonusNumber.of(3, primaryNumbers)
        }
    }
}
