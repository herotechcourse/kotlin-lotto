package lotto.view

import lotto.domain.GameResult
import lotto.domain.LottoTicket
import lotto.domain.Rank
import lotto.dto.IssuedTickets

object OutputView {

    object Result {
        fun purchase(manualTickets: IssuedTickets, randomTickets: IssuedTickets) {
            val manualNumber = manualTickets.size()
            val randomNumber = randomTickets.size()
            val pluralized = pluralizeTicket(manualNumber + randomNumber)
            println("Purchased $manualNumber manual and $randomNumber automatic $pluralized.")
        }

        fun issuedTickets(tickets: IssuedTickets) {
            tickets.get().forEach { println("[$it]") }
        }

        fun winningStatistics(gameResult: GameResult) {
            Prompt.winningStatisticsTitle()
            Rank.entries.filter { it != Rank.MISS }.reversed().forEach {
                eachRank(it, gameResult.ranks)
            }
            totalRate(gameResult.returnRate)
        }

        private fun eachRank(
            entry: Rank,
            results: List<Rank>,
        ) {
            val matchCount = results.count { it.countOfMatch == entry.countOfMatch }
            val hasBonus = if (entry.requiresBonus) " + Bonus Ball" else ""
            val winningMoney = "%,d".format(entry.winningMoney)
            val pluralizedTicket = pluralizeTicket(matchCount)
            println("${entry.countOfMatch} Matches$hasBonus ($winningMoney ${LottoTicket.CURRENCY}) - $matchCount $pluralizedTicket")
        }

        fun totalRate(totalRate: Double) {
            Prompt.totalReturnRate()
            println("%.2f".format(totalRate))
        }

        private fun pluralizeTicket(size: Int): String {
            return if (size == 1 || size == 0) "ticket" else "tickets"
        }
    }

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

        fun winningNumbers() {
            println(WINNING_NUMBERS_PROMPT)
        }

        fun bonusNumber() {
            println(BONUS_NUMBER_PROMPT)
        }

        fun winningStatisticsTitle() {
            println(TITLE_OF_RESULT_PROMPT)
        }

        fun totalReturnRate() {
            print(TOTAL_RETURN_PROMPT)
        }

        fun error(exception: Exception) {
            val msg = exception.message ?: "Unexpected error occurred."
            println("ERROR: $msg")
        }

        private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
        private const val NUMBER_OF_MANUAL_PROMPT = "Enter the number of manual tickets to purchase."
        private const val MANUAL_TICKET_PROMPT = "Enter the numbers for manual tickets."
        private const val WINNING_NUMBERS_PROMPT = "Please enter last week’s winning numbers."
        private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
        private const val TITLE_OF_RESULT_PROMPT = "Winning Statistics\n------------------"
        private const val TOTAL_RETURN_PROMPT = "Total return rate is "
    }
}