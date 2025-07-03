package lotto

object ResultView {
    fun displayNumberOfTickets(numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
    }

    fun displayTickets(bundleOfLottoTicket: List<LottoTicket>) {
        bundleOfLottoTicket.forEach { ticket ->
            println(ticket.numbers)
        }
        println()
    }

    fun displayWinningStatistics(resultTable: MutableList<Int>) {
        println("Winning Statistics")
        println("------------------")
        println("3 Matches (5,000 KRW) - ${resultTable[5]} tickets")
        println("4 Matches (50,000 KRW) - ${resultTable[4]} tickets")
        println("5 Matches (1,500,000 KRW) - ${resultTable[3]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${resultTable[2]} tickets")
        println("6 Matches (2,000,000,000 KRW) - ${resultTable[1]} tickets")
    }

    // TODO: make return rate output properly with 2 decimals
    fun displayReturnRate(returnRate: Double) {
        val processingResult = returnRate.toString()
        val result = processingResult.substring(0, processingResult.indexOf(".") + 2)
        println("Total return rate is ${String.format("%.2f", result.toDouble())} (A rate below 1 means a loss)")
    }
}
