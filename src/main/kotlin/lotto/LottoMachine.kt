package lotto

class LottoMachine(val userAmount: Int) {

    private fun calculateTickets() : Int{
        val numberOfTickets = userAmount / 1000
        return numberOfTickets
    }

    private fun generateNumbers() : List<Int> {
        val randomNumbers = (1..45).shuffled().take(6).sorted()
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

    fun compareTickets(lottos : List<Lotto>, winningNumber: List<String>, bonusNumber: Int){

    }
}