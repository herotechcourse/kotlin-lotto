package lotto

class RandomNumberGenerator {
    fun generateNumber(): List<Int> {
        val roughNumbers = (1..45).toList().shuffled()
        val generatedNumbers = roughNumbers.subList(0, 6)
        return generatedNumbers.sorted()
    }
}
