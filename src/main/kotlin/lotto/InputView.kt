package lotto

import kotlin.text.split

class InputView {
    val inputValidator = InputValidator()

    fun takePurchaseInput(): Int {
        println(ASK_AMOUNT)
        val input = readln().trim()
        inputValidator.validateAmount(input)
        return input.toInt()
    }

    fun takeQuantityOfManualTickets(totalPurchasedTickets: Int): Int? {
        println(ASK_MANUAL_TICKETS_AMOUNT)
        val input = readln().trim()
        inputValidator.validateManualTicketsAmount(input, totalPurchasedTickets)
        val inputTreated = input.toInt()
        return inputTreated
    }

    fun takeUserManualTicketNumbers(manualTicketsQuantity: Int): List<List<Int>> {
        val tickets = mutableListOf<List<Int>>()
        println(ASK_SIX_NUMBERS_FOR_MANUAL_TICKETS)
        repeat(manualTicketsQuantity) {
            val ticket = mutableListOf<Int>()
            val input = readln().split(",")
            val inputToMapList = input.map { item -> item.trim() }
            inputToMapList.forEach {
                inputValidator.validateManualListOfNumbers(it)
                val userNumberToInt = it.toInt()
                ticket.add(userNumberToInt)
            }
            tickets.add(ticket)
        }
        return tickets
    }

    fun takeWinningNumbers(): List<String> {
        println()
        println(ASK_WINNING_NUMBERS)
        val input = readln().split(",")
        input.forEach { item -> item.trim() }
        inputValidator.validateWinningNumbers(input)
        return input
    }

    fun takeBonusNumber(winningNumbers: List<String>): Int {
        println(ASK_BONUS_NUMBER)
        val bonusInput = readln()
        inputValidator.validateBonusNumber(bonusInput, winningNumbers)
        return bonusInput.toInt()
    }

    companion object {
        const val ASK_AMOUNT = "Please enter the purchase amount."
        const val ASK_WINNING_NUMBERS = "Please enter last week's winning numbers."
        const val ASK_BONUS_NUMBER = "Please enter the bonus number."
        const val ASK_MANUAL_TICKETS_AMOUNT = "Please enter the number of manual tickets you want."
        const val ASK_SIX_NUMBERS_FOR_MANUAL_TICKETS = "Enter the numbers for manual tickets."
    }
}
