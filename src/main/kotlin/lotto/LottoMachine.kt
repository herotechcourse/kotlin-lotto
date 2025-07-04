package lotto

class LottoMachine(val purchaseAmount: Int, val tickets: MutableList<Lotto> = emptyList<Lotto>().toMutableList()) {
    private val numberList = (Lotto.Companion.MIN..Lotto.Companion.MAX)
    private var change = 0
    private var ticketCount = 0

    init {
        require(purchaseAmount in MIN..MAX) {
            throw IllegalArgumentException()
        }
        change = purchaseAmount % TICKET_PRICE
        ticketCount = (purchaseAmount - change) / TICKET_PRICE
        generateTickets()
    }

    fun showChange() = change

    fun generateTickets() {
        repeat(ticketCount) {
            tickets.add(Lotto(generateNumbers()))
        }
    }

    private fun generateNumbers(): List<Int> {
        return numberList.shuffled().subList(0, Lotto.LOTTO_SIZE)
    }

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
        const val TICKET_PRICE = 1_000
    }
}
