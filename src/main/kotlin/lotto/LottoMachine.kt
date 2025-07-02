package lotto

class LottoMachine(val userAmount: Int) {

    fun calculateTickets() : Int{
        val numberOfTickets = userAmount / 1000
        return numberOfTickets
    }

    fun generateNumbers() : List<Int> {
        val randomNumbers = (1..45).shuffled().take(6)
        return randomNumbers
    }

    fun createTickets() : List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val amountOfTickets = calculateTickets()
        var count = 0
        while (count < amountOfTickets ) {
            val lotto = Lotto(generateNumbers())
            lottos.add(lotto)
            count++
        }
        return lottos
    }
}