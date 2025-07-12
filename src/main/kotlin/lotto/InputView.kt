package lotto

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput % LottoTicket.COST_OF_TICKET == 0)
        return userInput
    }

    fun getManualTicketCount(maxTicketCount: Int): Int {
        println("Enter the number of manual tickets to purchase.")
        val input = readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid number.")
        require(input in 0..maxTicketCount) { "You can enter between 0 and $maxTicketCount manual tickets." }
        return input
    }

    fun getManualTickets(count: Int): List<LottoTicket> {
        println("Enter the numbers for manual tickets.")
        return List(count) {
            val line = readln()
            ManualTicketParser.parse(line)
        }
    }

    fun getLastWeekWinningNumbers(): WinningNumbers  {
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
        return WinningNumbers(finalInput.sorted())
    }

    fun getBonusNumber(): BonusNumber {
        println("Please enter the bonus number.")
        val input = readln()
        val userInput = input.toIntOrNull() ?: throw IllegalArgumentException("This is not a number.")
        require(userInput > 0)
        require(userInput < 46)
        return BonusNumber(userInput)
    }
}
