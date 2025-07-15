package lotto.domain

@JvmInline
value class LottoNumber(private val value: Int) {
    companion object {
        internal const val MIN_RANGE_NUMBER = 1
        internal const val MAX_RANGE_NUMBER = 45
        private val LOTTO_NUMBERS = (MIN_RANGE_NUMBER..MAX_RANGE_NUMBER).associateWith(::LottoNumber)

        fun from(request: Int): LottoNumber {
            return LOTTO_NUMBERS[request] ?: throw IllegalArgumentException()
        }
    }

    override fun toString(): String = value.toString()
}
