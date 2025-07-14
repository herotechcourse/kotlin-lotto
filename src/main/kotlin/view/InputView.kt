package view

import lotto.LottoNumbers

object InputView {
    fun getAmountInput(): Int {
        println("Please enter the purchase amount.")
        val inputString = readLine() ?: ""
        val amount = inputString.toIntOrNull()
        require(amount != null && amount > 0) {
            "Input cannot be empty."
        }
        return amount
    }

    fun getManualTicketCount(): Int {
        println("Enter the number of manual tickets to purchase.")
        val inputString = readLine() ?: ""
        val count = inputString.toIntOrNull()
        require(count != null && count >= 0) {
            "Manual ticket count must be 0 or greater."
        }
        return count
    }

    fun getInputForNumber() = println("Enter the numbers for manual tickets.")

    fun getManualNumbers(): LottoNumbers {
        val inputString = readLine() ?: ""
        require(inputString.isNotBlank()) {
            "Input cannot be empty."
        }
        val numbers = inputString.split(",").map { it.trim().toIntOrNull() }
        require(numbers.all { it != null }) {
            "Invalid input format."
        }
        val validNumbers = numbers.filterNotNull().sorted().toSet()
        val manuelTickets = LottoNumbers(validNumbers)
        return manuelTickets
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val inputString = readLine() ?: ""
        require(inputString.isNotBlank()) {
            "Input cannot be empty."
        }
        val numbers = inputString.split(",").map { it.trim().toIntOrNull() }
        require(numbers.all { it != null }) {
            "Invalid input format."
        }
        val winningTickets = numbers.filterNotNull().sorted()
        return winningTickets
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readLine() ?: ""
        require(input.isNotBlank()) {
            "Input cannot be empty."
        }
        return input.toIntOrNull() ?: 0
    }
}
