package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `List of size 6`() {
        assertThrows<IllegalArgumentException> { Lotto.from(listOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `Numbers should be between 0 and 50`() {
        assertThrows<IllegalArgumentException> { Lotto.from(listOf(1, 2, 3, 4, 5, 51)) }
    }

    @Test
    fun `List has unique elements`() {
        assertThrows<IllegalArgumentException> { Lotto.from(listOf(1, 2, 3, 4, 5, 5)) }
    }
}
