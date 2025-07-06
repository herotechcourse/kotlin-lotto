package view

object InputView {
    fun getAmountInput(): Int {
        println("Please enter the purchase amount.")
        val input = readLine() ?: ""
        require(input.isNotBlank()) {
            "Input cannot be empty."
        }
        return input.toIntOrNull() ?: 0
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = readLine() ?: ""
        require(input.isNotBlank()) {
            "Input cannot be empty."
        }
        return input.split(",").map { it.toIntOrNull() ?: 0 }
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
