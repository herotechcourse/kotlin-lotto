package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `throws exception when input is not a number` () {
        val inputView = InputView()

        assertThrows<IllegalArgumentException>{
            inputView.takeInput()
        }
    }
}