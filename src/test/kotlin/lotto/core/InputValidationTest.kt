package lotto.core

import lotto.model.InputValidation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputValidationTest {
    // Purchase Validation Test
    @Test
    fun `should throw if less then 1000`() {
        val purchaseAmount = 999
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(purchaseAmount) }
    }

    @Test
    fun `should throw if zero`() {
        val purchaseAmount = 0
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(purchaseAmount) }
    }

    @Test
    fun `should throw negative`() {
        val purchaseAmount = -1000
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(purchaseAmount) }
    }

    @Test
    fun `should throw if not divisible by 1000`() {
        val purchaseAmount = 1500
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(purchaseAmount) }
    }

    @Test
    fun `should return the right purchase amount`() {
        val purchaseAmount = 2000
        assertThat(purchaseAmount).isEqualTo(InputValidation.validatePurchaseAmount(purchaseAmount))
    }

    //  Lotto numbers Validation
    @Test
    fun `lotto numbers should be unique numbers`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> { InputValidation.validateLottoNumbersInput(winningLotto) }
    }

    @Test
    fun `lotto numbers should has to be exactly 6 numbers`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> { InputValidation.validateLottoNumbersInput(winningLotto) }
    }

    @Test
    fun `lotto numbers should has to be exactly 6 numbers_2`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> { InputValidation.validateLottoNumbersInput(winningLotto) }
    }

    @Test
    fun `lotto numbers must be in range 1 - 50`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 51)
        assertThrows<IllegalArgumentException> { InputValidation.validateLottoNumbersInput(winningLotto) }
    }

    // Number of manual tickets number validation
    @Test
    fun `manual numbers of tickets must be in range 0 - numberMaximaTickets`() {
        val numberManualTicketsInput = 10
        val numberTicketsAvailable = 9
        assertThrows<IllegalArgumentException> {
            InputValidation.validateNumberManualTicketsInput(
                numberManualTickets = numberManualTicketsInput,
                maximalNumberOfTickets = numberTicketsAvailable,
            )
        }
    }

    @Test
    fun `manual numbers of tickets must be greater than 0`() {
        val numberManualTicketsInput = -10
        val numberTicketsAvailable = 9
        assertThrows<IllegalArgumentException> {
            InputValidation.validateNumberManualTicketsInput(
                numberManualTickets = numberManualTicketsInput,
                maximalNumberOfTickets = numberTicketsAvailable,
            )
        }
    }

    // bonus number validation
    @Test
    fun `should throw if bonus number is negative`() {
        val bonusNumber = -1
        val winningNumber = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputValidation.validateBonusNumberInput(
                winningNumbers = winningNumber,
                bonusNumberInput = bonusNumber,
            )
        }
    }

    @Test
    fun `should throw if bonus number is zero`() {
        val bonusNumber = 0
        val winningNumber = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputValidation.validateBonusNumberInput(
                winningNumbers = winningNumber,
                bonusNumberInput = bonusNumber,
            )
        }
    }

    @Test
    fun `should throw if bonus number is greater the 50`() {
        val bonusNumber = 51
        val winningNumber = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputValidation.validateBonusNumberInput(
                winningNumbers = winningNumber,
                bonusNumberInput = bonusNumber,
            )
        }
    }

    @Test
    fun `should throw if bonus number in the winning numbers`() {
        val bonusNumber = 1
        val winningNumber = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputValidation.validateBonusNumberInput(
                winningNumbers = winningNumber,
                bonusNumberInput = bonusNumber,
            )
        }
    }
}
