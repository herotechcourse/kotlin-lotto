package lotto

import lotto.model.Numbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {
    @Test
    fun `Throws an exception if numbers list is empty`() {
        assertThrows<IllegalArgumentException> { Numbers(emptyList()) }
    }

    @Test
    fun `Throws an exception if numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Numbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `Throws an exception if numbers size exceeds desired size`() {
        assertThrows<IllegalArgumentException> {
            Numbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `Throws an exception if numbers size small than desired size`() {
        assertThrows<IllegalArgumentException> {
            Numbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `Throws an exception when numbers contain number exceeds maximum limit`() {
        assertThrows<IllegalArgumentException> {
            Numbers(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `Throws an exception when numbers contain number smaller than minimum limit`() {
        assertThrows<IllegalArgumentException> {
            Numbers(listOf(1, 2, 3, 4, 5, 0))
        }
    }
}
