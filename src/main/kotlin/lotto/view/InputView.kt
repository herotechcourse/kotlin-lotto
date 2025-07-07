package lotto.view

import lotto.model.LottoTicket

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput > 0) { "You must provide a valid amount of purchase, bigger than 0." }
        require(userInput % 1000 == 0) { "You must provide a valid amount of purchase, dividable to 1000." }
        return userInput
    }

    fun getLottoNumbers(): List<Int> {
        val input = readln() // -> "1,2,3,4,5,6"
        val usedInput = input.split(",") // -> ["1", " 2", " 3", " 4", " 5", " 6"]
        val userInput = usedInput.map { it.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.") }
        userInput.forEach { minMaxNumberValidator(it) }
        val finalInput = userInput.distinct()
        require(finalInput.size == 6) { "Invalid Input." }
        return finalInput.sorted()
    }

    fun getNumberOfManualTickets(amountOfTicket: Int): Int {
        println("\nEnter the number of manual tickets to purchase.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput <= amountOfTicket) { "The number of manual tickets should be between 1 and $amountOfTicket." }
        return userInput
    }

    fun informForManualTicketNumbers() {
        println("\nEnter the numbers for manual tickets.")
    }

    fun getLastWeekWinningNumbers(): List<Int> {
        println("\nPlease enter last week’s winning numbers.")
        return getLottoNumbers()
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        minMaxNumberValidator(userInput)
        return userInput
    }

    fun minMaxNumberValidator(inputNumber: Int): Boolean {
        require(inputNumber >= LottoTicket.Companion.MIN_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
        require(inputNumber <= LottoTicket.Companion.MAX_LOTTO_NUMBER) { Message.ERROR_MESSAGE_FOR_LOTTO_NUMBER }
        return true
    }

    object Message {
        const val ERROR_MESSAGE_FOR_LOTTO_NUMBER =
            "You must provide a number between ${LottoTicket.Companion.MIN_LOTTO_NUMBER} and ${LottoTicket.Companion.MAX_LOTTO_NUMBER}."
    }
}
