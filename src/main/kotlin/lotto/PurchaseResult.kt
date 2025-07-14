package lotto

import view.ResultView

data class PurchaseResult(
    val money: Money,
    val tickets: List<Lotto>,
    val manualCount: Int,
) {
    fun totalTicketCount(): Int = tickets.size

    fun ticketCounts(): Pair<Int, Int> {
        val autoCount = totalTicketCount() - manualCount
        return manualCount to autoCount
    }

    fun deliverTickets(): List<Lotto> = tickets

    fun purchaseAmount(): Int = money.amount

    fun renderTicketsTo(view: ResultView) {
        val (manual, auto) = ticketCounts()
        view.viewTicketsAmount(totalTicketCount())
        view.viewTickets(tickets, manual, auto)
    }
}
