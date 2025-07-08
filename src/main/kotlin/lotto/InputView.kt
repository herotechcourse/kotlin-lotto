package lotto

private const val INPUT_ERROR_MESSAGE = "[ERROR] Wrong input"

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val amount = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week’s winning numbers.")
        val numbers =
            readln().split(",")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
                }
        return numbers
    }

    fun readManualTickets(): List<Int> {
        println("Please enter the numbers for the manual tickets.")
        val numbers =
            readln().split(",")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
                }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        println()
        return number
    }

    fun readNumberOfManualTickets(): Int {
        println("Please enter the number of manual tickets to purchase.")
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        println()
        return number
    }
}
