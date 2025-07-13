package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 45])
    fun `test valid range`(number: Int) {
        assertDoesNotThrow { LottoNumber.from(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `test invalid range`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }

    @Test
    fun `test comparison`() {
        assertEquals((LottoNumber.from(12)), LottoNumber.from(12))
    }
}