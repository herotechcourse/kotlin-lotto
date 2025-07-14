package lotto

@JvmInline
value class Money private constructor(val amount: Int) {
    companion object {
        const val TICKET_COST = 1000

        fun of(amount: Int): Money {
            require(amount >= 1000) {
                "the amount should be minumum 1,000 KRW"
            }
            require(amount % 1000 == 0) {
                "the amount should be divisible by 1000"
            }
            return Money(amount)
        }
    }

    fun canPurchaseTickets(ticketCount: Int) {
        val max = maxTickets(amount)
        require(ticketCount <= max) {
            "You can't purchase more than $max tickets."
        }
    }

    fun maxTickets(amount: Int): Int = amount / TICKET_COST
}
