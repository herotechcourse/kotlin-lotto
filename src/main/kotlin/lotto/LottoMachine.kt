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
}