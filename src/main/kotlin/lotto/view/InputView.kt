package lotto.view

object InputView {
    fun readPurchaseAmount(): Int {
        println(PURCHASE_MESSAGE)
        val amount = readln().trim().toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE)
        return amount
    }

    fun readManualTicketCount(): Int {
        println("\n$MANUAL_TICKET_COUNT_MESSAGE")
        val count = readln().trim().toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE)
        println()
        return count
    }

    fun readWinningTicket(): List<Int> {
        println(WINNING_TICKET_MESSAGE)
        return readTicket()
    }

    fun readManualTicket(): List<Int> {
        println(MANUAL_TICKET_MESSAGE)
        return readTicket()
    }

    private fun readTicket(): List<Int> {
        val numbers =
            readln().split(",")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE)
                }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("\n$BONUS_NUMBER_MESSAGE")
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE)
        println()
        return number
    }

    private const val PURCHASE_MESSAGE = "Please enter the purchase amount."
    private const val WINNING_TICKET_MESSAGE = "Please enter last week’s winning numbers."
    private const val MANUAL_TICKET_COUNT_MESSAGE = "Enter the number of manual tickets to purchase."
    private const val MANUAL_TICKET_MESSAGE = "Enter the numbers for manual tickets."
    private const val BONUS_NUMBER_MESSAGE = "Please enter the bonus number."
    private const val ERROR_MESSAGE = "[ERROR] Wrong input"
}
