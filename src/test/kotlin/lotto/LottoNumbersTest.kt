package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `it should create LottoNumbers with 6 unique numbers in range`() {
        val numbers = listOf(1, 5, 12, 23, 34, 45)
        val lottoNumbers = LottoNumbers.of(numbers)
        assertThat(numbers.toSet()).isEqualTo(lottoNumbers.numbers)
    }

    @Test
    fun `if numbers size is not 6 throw`() {
        val numbers = listOf(1, 2, 3)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.of(numbers)
        }
    }

    @Test
    fun `if numbers are not unique throw`() {
        val numbers = listOf(1, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.of(numbers)
        }
    }

    @Test
    fun `if any number is out of range throw`() {
        val numbersLow = listOf(0, 2, 3, 4, 5, 6)
        val numbersHigh = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> { LottoNumbers.of(numbersLow) }
        assertThrows<IllegalArgumentException> { LottoNumbers.of(numbersHigh) }
    }
}
