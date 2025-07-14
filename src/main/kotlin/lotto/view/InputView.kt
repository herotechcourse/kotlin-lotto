package lotto.view

import lotto.domain.LottoNumber
import lotto.exceptions.LottoException

object InputView {
    fun readUserAmount(): Int {
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidAmountFormatException(input)
    }

    fun readManualSize(amount: Int): Int {
        val input = readln()
        val numberOfManual = input.trim().toIntOrNull() ?: throw IllegalArgumentException()
        require(count > 0 && numberOfManual <= count)
        return numberOfManual
    }

    fun readManualNumbers(): Set<Int> {
        val input = readln()
        return input
            .split(',')
            .map {
                it.trim().toIntOrNull()
                    ?: throw LottoException.InvalidWinningNumbersFormatException(input)
            }.toSortedSet()
    }

    fun readBonusNumber(winningNumbers: Set<Int>): LottoNumber {
        val input = readln()
        val bonusNumber = input.trim().toIntOrNull() ?: throw LottoException.InvalidWinningNumbersFormatException(input)
        if (winningInput.contains(bonusNumber))
            throw LottoException.InvalidWinningNumbersFormatException(input)
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
