package view

object InputView {
    fun getNumberOfManuelTickets(): Int =
        retry(NUMBER_OF_TICKETS_PROMPT) {
            parseNumber(readLine() ?: "")
        }

    fun getNumbersForTicket(): List<Int> =
        retry(NUMBERS_FOR_TICKET_PROMPT) {
            parseNumbers(readLine() ?: "")
        }

    fun getPurchaseAmount(): Int =
        retry(PURCHASE_AMOUNT_PROMPT) {
            parseNumber(readLine() ?: "")
        }

    fun getWinningNumbers(): List<Int> =
        retry(WINNING_NUMBERS_PROMPT) {
            parseNumbers(readLine() ?: "")
        }

    fun getBonusNumber(): Int =
        retry(BONUS_NUMBER_PROMPT) {
            parseNumber(readLine() ?: "")
        }

    private fun parseNumbers(input: String): List<Int> {
        require(input.isNotBlank()) {
            ERROR_MSG
        }
        return input.split(",").map { it.toIntOrNull() ?: 0 }
    }

    private fun parseNumber(input: String): Int {
        require(input.isNotBlank()) {
            ERROR_MSG
        }
        return input.toIntOrNull() ?: 0
    }

    private fun <T> retry(
        prompt: String,
        block: () -> T,
    ): T {
        while (true) {
            try {
                println(prompt)
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private const val ERROR_MSG = "Input cannot be empty."
    private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
    private const val WINNING_NUMBERS_PROMPT = "Please enter last week's winning numbers."
    private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    private const val NUMBERS_FOR_TICKET_PROMPT = "Enter the numbers for manual tickets."
    private const val NUMBER_OF_TICKETS_PROMPT = "Enter the number of manual tickets to purchase."
}
