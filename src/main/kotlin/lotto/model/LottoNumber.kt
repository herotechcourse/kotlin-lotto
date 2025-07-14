package lotto.model

@JvmInline
value class LottoNumber(private val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 50
        private val NUMBERS: Map<Int, LottoNumber> =
            (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
