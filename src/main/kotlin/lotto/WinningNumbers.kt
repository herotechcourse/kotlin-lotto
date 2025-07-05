package lotto

data class WinningNumbers(val winningNumbers: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber in Lotto.MIN..Lotto.MAX) {
            "[ERROR] Bonus number is out of range."
        }
        require(!winningNumbers.numbers.contains(bonusNumber)) {
            "[ERROR] Winning numbers already contain $bonusNumber."
        }
    }
}
