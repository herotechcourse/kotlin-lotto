package lotto

class Money(val value: Int) {
    init {
        require(value >= 1000) {
            "the amount should be minumum 1,000 KRW"
        }
        require(value % 1000 == 0) {
            "the amount should be divisible by 1000"
        }
    }
}
