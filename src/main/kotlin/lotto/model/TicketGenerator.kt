package lotto.model

object TicketGenerator {
    fun generateAutomaticTickets(count: Int): List<Lotto> {
        return List(count) {
            Lotto.fromInts(Random.generateSetOfSixRandomNumbers())
        }
    }

    fun generateManualTickets(inputs: List<Set<Int>>): List<Lotto> {
        return inputs
            .map { ticket -> Lotto.fromInts(ticket) }
            .toList()
    }
}
