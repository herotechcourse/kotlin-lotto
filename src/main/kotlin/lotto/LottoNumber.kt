package lotto

class LottoNumber(val value: Int) {
    init {
        require(isInRange(value))
    }

    private fun isInRange(value: Int): Boolean {
        return value in 1..45
    }
}
