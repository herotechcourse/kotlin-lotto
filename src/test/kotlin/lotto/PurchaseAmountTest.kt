package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 999, 20_001, 21_000])
    fun `Purchase amount should be minimum 1_000 and (maximum 20_000 KRW)`(number: Int) {
        assertThrows<IllegalArgumentException> { PurchaseAmount(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1_000, 20_000])
    fun `Purchase amount should be in range of 1_000 and (maximum 20_000 KRW)`(number: Int) {
        assertEquals(PurchaseAmount(number).amount, number)
    }
}
