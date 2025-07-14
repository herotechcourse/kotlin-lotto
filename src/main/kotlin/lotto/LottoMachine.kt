package lotto

class LottoMachine() {
    fun issueTickets(
        quantity: Int,
        numberGenerator: () -> List<Int>,
    ): List<Lotto> {
        return (1..quantity).map {
            Lotto(numberGenerator().map { LottoNumber.from(it) })
        }
    }
}
