package lotto.model

object Random {
    fun generateSetOfSixRandomNumbers(): Set<Int> {
        return (1..50).shuffled().take(6).sorted().toSet()
    }
}
