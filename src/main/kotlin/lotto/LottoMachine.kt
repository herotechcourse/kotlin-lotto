package lotto

class LottoMachine(private val money: Money, manuallyEnteredNumbers: List<LottoNumbers>) {
    val tickets: List<Lotto>

    init {
        money.canPurchaseTickets(manuallyEnteredNumbers.size)

        val manualLottoTickets = generateManualLottoTickets(manuallyEnteredNumbers)
        val remainingTicketCount = getAutomaticRemainingTicketsCount(manualLottoTickets)
        val automaticLottoTickets = automaticLottoTickets(remainingTicketCount)

        tickets = manualLottoTickets + automaticLottoTickets
    }

    private fun generateManualLottoTickets(numbers: List<LottoNumbers>): List<Lotto> {
        return numbers.map(::Lotto)
    }

    private fun getAutomaticRemainingTicketsCount(manualLottoTickets: List<Lotto>): Int {
        return money.maxTickets(money.amount) - manualLottoTickets.size
    }

    private fun automaticLottoTickets(remainingTicketCount: Int): List<Lotto> {
        val automaticTickets = List(remainingTicketCount) { Lotto(LottoNumbers.of(generateRandomNumber())) }
        return automaticTickets
    }

    fun provideTickets(): List<Lotto> = tickets

    private fun generateRandomNumber() = (1..45).shuffled().take(6).sorted()
}
