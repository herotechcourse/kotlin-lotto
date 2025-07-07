package lotto.view

import lotto.exceptions.LottoException

object InputView {
    fun readUserAmount(): Int {
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidAmountFormatException(input)
    }

    fun readNumberOfManual(amount: Int): Int {
        val input = readln()
        val integerInput = input.trim().toIntOrNull() ?: throw IllegalArgumentException()
        require(amount > 0 && integerInput <= amount)
        return integerInput
    }

    fun readManualNumbers(): Set<Int> {
        val input = readln()
        return input
            .split(',')
            .map {
                it.trim().toIntOrNull()
                    ?: throw LottoException.InvalidWinningNumbersFormatException(input)
            }.toSet()
    }

    fun readBonusNumber(): Int {
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidBonusNumberFormatException(input)
    }

    /**
     * Template function that accept a lambda
     * returns only in case of successfully
     */
    private fun <T> retryUntilSuccess(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: LottoException) {
                println(e.message)
            }
        }
    }
}
