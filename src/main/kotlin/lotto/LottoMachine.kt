package lotto

class LottoMachine(val userAmount: Int) {

    fun calculateTickets() : Int{
        val numberOfTickets = userAmount / 1000
        return numberOfTickets
    }

}