package lotto

class LottoMachine(
    val purchaseAmount: PurchaseAmount,
    val enteredTicketCount: EnteredTicketCount,
    val tickets: MutableList<Lotto> = emptyList<Lotto>().toMutableList(),
) {
    var change = 0
        private set
    var generatedTicketCount = 0
        private set

    val manualTicketCount: Int
        get() = enteredTicketCount.count

    init {
        val purchasableTickets = purchaseAmount.amount / TICKET_PRICE
        require(enteredTicketCount.count <= purchasableTickets) { COUNT_ERROR_MESSAGE }

        generatedTicketCount = purchasableTickets - enteredTicketCount.count
        change = purchaseAmount.amount % TICKET_PRICE
        generateTickets()
    }

    fun appendManualTickets(manualTickets: List<Lotto>) {
        tickets.addAll(manualTickets)
    }

    private fun generateTickets() {
        val lottoTickets = List(generatedTicketCount) { Lotto(generateNumbers()) }
        tickets.addAll(lottoTickets)
    }

    private fun generateNumbers(): List<LottoNumber> =
        NUMBER_LIST
            .shuffled()
            .take(Lotto.LOTTO_SIZE)

    companion object {
        private val NUMBER_LIST =
            (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER)
                .map(LottoNumber::from)
        private const val COUNT_ERROR_MESSAGE = "Count should be less than Purchasable Tickets"
        const val TICKET_PRICE = 1_000
    }
}
