package lotto.view

import lotto.exceptions.LottoException

object InputView {
    // TODO: separate to I/O get..() methods
    fun getPurchaseAmount(): Int {
        println(Constants.PURCHASE_PROMPT)
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidAmountFormatException(input)
    }

    fun getWinningNumbers(): List<Int> {
        println(Constants.WINNING_NUMBERS_PROMPT)
        val input = readln()
        return input
            .split(',')
            .map {
                it.trim().toIntOrNull()
                    ?: throw LottoException.InvalidWinningNumbersFormatException(input)
            }
    }

    fun getBonusNumber(): Int {
        println(Constants.BONUS_NUMBER_PROMPT)
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidBonusNumberFormatException(input)
    }

    fun readUserAmount(): Int {
        val input = readln()
        return input.trim().toIntOrNull() ?: throw LottoException.InvalidAmountFormatException(input)
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
