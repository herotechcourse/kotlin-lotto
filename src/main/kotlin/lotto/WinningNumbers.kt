package lotto

data class WinningNumbers(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(doesNotContain(bonusNumber)) { ERROR_MESSAGE }
    }

    private fun doesNotContain(number: LottoNumber): Boolean {
        return !winningNumbers.numbers.contains(number)
    }

    companion object {
        private const val ERROR_MESSAGE =
            "Bonus Number should not be present in the Winning Numbers"
    }
}
