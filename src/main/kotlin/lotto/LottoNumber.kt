package lotto

class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(isInRange(value))
    }

    private fun isInRange(value: Int): Boolean {
        return value in 1..45
    }

    override fun compareTo(other: LottoNumber): Int {
        return value - other.value
    }
}
