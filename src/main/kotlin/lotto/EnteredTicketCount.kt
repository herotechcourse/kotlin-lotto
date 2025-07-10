package lotto

@JvmInline
value class EnteredTicketCount(val count: Int) {
    init {
        require(count >= 0) { "Manual ticket count should be a positive number" }
    }
}
