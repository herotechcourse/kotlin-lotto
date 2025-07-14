package lotto.view

import lotto.domain.LottoNumber
import lotto.exceptions.ExceptionMessage
import lotto.exceptions.Validator

object InputView {
    fun readUserAmount(): Int {
        val input = readln()
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.CONVERTED_NULL)
        Validator.amount(amount)
        return amount
    }

    fun readManualSize(amount: Int): Int {
        val input = readln()
        val size = input.trim().toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.CONVERTED_NULL)
        Validator.purchase(amount, size)
        return size
    }

    fun readManualNumbers(): Set<Int> {
        val input = readln()
        val numbers =
            input
                .split(',')
                .map {
                    it.trim().toIntOrNull()
                        ?: throw IllegalArgumentException(ExceptionMessage.CONVERTED_NULL)
                }.toSortedSet()
        Validator.numbers(numbers)
        return numbers
    }

    fun readBonusNumber(winningNumbers: Set<Int>): LottoNumber {
        val input = readln()
        val bonusNumber = input.trim().toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.CONVERTED_NULL)
        Validator.bonusNumber(bonusNumber, winningNumbers)
        return LottoNumber.from(bonusNumber)
    }

    /**
     * Template function that accept a lambda
     * returns only in case of successfully
     */
    fun <T> retriable(
        prompt: () -> Unit,
        read: () -> T,
    ): T {
        while (true) {
            try {
                prompt()
                return read()
            } catch (e: IllegalArgumentException) {
                println("[Error]: ${e.message}")
            }
        }
    }
}
