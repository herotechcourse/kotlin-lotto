package lotto.view

import lotto.dto.IssuedTickets

object OutputView {

    object Prompt {
        fun amount() {
            println(PURCHASE_AMOUNT_PROMPT)
        }

        fun numberOfManual() {
            println(NUMBER_OF_MANUAL_PROMPT)
        }

        fun manualNumbers() {
            println(MANUAL_TICKET_PROMPT)
        }

        private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
        private const val NUMBER_OF_MANUAL_PROMPT = "Enter the number of manual tickets to purchase."
        private const val MANUAL_TICKET_PROMPT = "Enter the numbers for manual tickets."
        private const val WINNING_NUMBERS_PROMPT = "Please enter last week’s winning numbers."
        private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
        private const val TITLE_OF_RESULT_PROMPT = "Winning Statistics\n------------------"
        private const val TOTAL_RETURN_PROMPT = "Total return rate is"
    }

    object Result {
        fun purchase(manualTickets: IssuedTickets, randomTickets: IssuedTickets) {
            val manualNumber = manualTickets.size()
            val randomNumber = randomTickets.size()
            val pluralized = pluralizeTicket(manualNumber + randomNumber)
            println("Purchased $manualNumber manual and $randomNumber automatic $pluralized.")
        }

    }

    private fun pluralizeTicket(size: Int): String {
        return if (size == 1 || size == 0) "ticket" else "tickets"
    }

    // TODO: clean up print methods
    /*
    fun printTickets(tickets: List<Lotto>) {
        val numberOfTickets = tickets.size
        println(
            "${Prompt.TICKETS_NUMBERS_PROMPT} " +
                "$numberOfTickets ${pluralizeTicket(numberOfTickets)}.",
        )
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun printResult(
        ranks: List<Rank>,
        returnRate: Double,
    ) {
        println(Constants.TITLE_OF_RESULT_PROMPT)
        Rank.entries.filter { it != Rank.MISS }.reversed().forEach { printResultLine(it, ranks) }
        println("${Constants.TOTAL_RETURN_PROMPT} ${"%.2f".format(returnRate)}")
    }

    private fun printResultLine(
        entry: Rank,
        results: List<Rank>,
    ) {
        val matchCount = results.count { it.countOfMatch == entry.countOfMatch }
        val hasBonus = if (entry.requiresBonus) " + Bonus Ball" else ""
        val winningMoney = "%,d".format(entry.winningMoney)
        val pluralizedTicket = pluralizeTicket(matchCount)
        println("${entry.countOfMatch} Matches$hasBonus ($winningMoney ${Lotto.CURRENCY}) - $matchCount $pluralizedTicket")
    }

    private fun pluralizeTicket(size: Int): String {
        return if (size == 1) "ticket" else "tickets"
    }
    */
}
