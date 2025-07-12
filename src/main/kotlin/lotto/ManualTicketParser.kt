package lotto

class ManualTicketParser {
    fun parse(line: String): LottoTicket {
        val numbers =
            line.split(",")
                .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("Invalid number.") }

        require(numbers.size == 6) { "Each ticket must have 6 numbers." }
        require(numbers.distinct().size == 6) { "Numbers must be unique." }
        numbers.forEach {
            require(it in 1..45) { "Number out of range." }
        }

        return LottoTicket(numbers.sorted())
    }
}
