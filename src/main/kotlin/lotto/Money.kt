package lotto

class Money(val amount: Int) {
    init {
        require(amount >= 1000) {
            "the amount should be minumum 1,000 KRW"
        }
        require(amount % 1000 == 0) {
            "the amount should be divisible by 1000"
        }
    }
}
