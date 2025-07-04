package lotto

object InputView {
    // TODO: Have to deal with the exception
    // How about dealing it with retryable command?
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput % 1000 == 0) { "You must provide a valid amount of purchase." }
        return userInput
    }

    // TODO: Exceeding 10 lines, have to refactor later.
    fun getLastWeekWinningNumbers(): List<Int> {
        println("Please enter last week’s winning numbers.")
        val input = readln() // -> "1,2,3,4,5,6"
        val usedInput = input.split(",") // -> ["1", " 2", " 3", " 4", " 5", " 6"]
        val userInput = usedInput.map { it.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.") }
        userInput.forEach {
            require(it >= LottoTicket.MIN_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
            require(it <= LottoTicket.MAX_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
        }
        val finalInput = userInput.distinct()
        require(finalInput.size == 6) { "Invalid Input." }
        return finalInput.sorted()
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput >= LottoTicket.MIN_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
        require(userInput <= LottoTicket.MAX_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
        return userInput
    }

    object Message {
        const val ERROR_MESSAGE_FOR_LOTTO_NUMBER =
            "You must provide a number between ${LottoTicket.MIN_LOTTO_NUMBER} and ${LottoTicket.MAX_LOTTO_NUMBER}."
    }
}
