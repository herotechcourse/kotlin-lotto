package lotto

class Money(val value: Int) {
    init {
        require(value >= TICKET_PRICE) {
            "the amount should be minimum 1,000 KRW"
        }
        require(value % TICKET_PRICE == 0) {
            "the amount should be divisible by $TICKET_PRICE"
        }
    }
}
