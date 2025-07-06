package lotto

class LottoMachine(val money: Money) {
    val tickets: List<Lotto> = issueTickets()

    fun issueTickets(): List<Lotto> {
        val ticketCount: Int = money.value / TICKET_PRICE

        return (1..ticketCount).map {
            Lotto(generateRandomNumber())
        }
    }

    private fun generateRandomNumber() = (1..45).shuffled().take(6).sorted()
}
