package lotto

private const val INPUT_ERROR_MESSAGE = "[ERROR] Wrong input"

object InputView {
    fun readPurchaseAmount(): Int {
        println("\nPlease enter the purchase amount.")
        val amount = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week’s winning numbers.")
        val numbers =
            readln().split(",")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
                }
        return numbers
    }

    fun promptForManualTickets() = println("\nPlease enter the numbers for the manual tickets.")

    fun readManualTickets(): List<Int> {
        val numbers =
            readln().split(",")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
                }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        return number
    }

    fun readNumberOfManualTickets(): Int {
        println("\nPlease enter the number of manual tickets to purchase.")
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        return number
    }
}
