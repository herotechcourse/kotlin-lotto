package lotto

object InputView {
    // TODO: Have to deal with the exception
    // How about dealing it with retryable command?
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput % 1000 == 0)
        return userInput
    }

    // TODO: Exceeding 10 lines, have to refactor later.
    fun getLastWeekWinningNumbers(): List<Int> {
        println("Please enter last week’s winning numbers.")
        val input = readln() // -> "1,2,3,4,5,6"
        val usedInput = input.split(",") // -> ["1", " 2", " 3", " 4", " 5", " 6"]
        val userInput = usedInput.map { it.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.") }
        userInput.forEach {
            require(it > 0)
            require(it < 46)
        }
        val finalInput = userInput.distinct()
        require(finalInput.size == 6) { "Invalid Input." }
        return finalInput
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput > 0)
        require(userInput < 46)
        return userInput
    }
}
