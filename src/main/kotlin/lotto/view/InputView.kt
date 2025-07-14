package lotto.view

import lotto.model.InputValidation

object InputView {
    fun purchaseAmountInput(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount:")
                val input = readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                return InputValidation.validatePurchaseAmount(input)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun winningNumbersInput(): Set<Int> {
        while (true) {
            try {
                println("\nPlease enter last week’s winning numbers.")
                val winningNumbers = readlnOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                val winningLottoNumbers = winningNumbers.split(",").map { it.toInt() }
                InputValidation.validateLottoNumbersInput(winningLottoNumbers)
                return winningLottoNumbers.toSet()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumberInput(winningNumbers: Set<Int>): Int {
        while (true) {
            try {
                println("\nPlease enter the bonus number.")
                val bonusNumber = readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                InputValidation.validateBonusNumberInput(winningNumbers, bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getManualTicketsNumber(maximalNumberOfTickets: Int): Int {
        while (true) {
            try {
                println("\nEnter the number of manual tickets to purchase.")
                val numberManualTickets =
                    readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                InputValidation.validateNumberManualTicketsInput(numberManualTickets, maximalNumberOfTickets)
                return numberManualTickets
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getManualTickets(numberManualTickets: Int): List<Set<Int>> {
        val tickets = mutableListOf<Set<Int>>()
        println("\nEnter the numbers for manual tickets.")
        while (tickets.size < numberManualTickets) {
            try {
                val ticketNumbers = readlnOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                val lottoNumbers = ticketNumbers.split(",").map { it.trim().toInt() }
                InputValidation.validateLottoNumbersInput(lottoNumbers)
                tickets.add(lottoNumbers.toSet())
            } catch (e: IllegalArgumentException) {
                println("${e.message}. Please try again.")
            } catch (e: NumberFormatException) {
                println(Error.INVALID_INPUT.message)
            }
        }
        return tickets
    }
}
