package lotto.domain

data class LottoNumber private constructor(private val value: Int) {
    companion object {
        internal const val MIN_RANGE_NUMBER = 1
        internal const val MAX_RANGE_NUMBER = 45
        private val LOTTO_NUMBERS = (MIN_RANGE_NUMBER..MAX_RANGE_NUMBER).associateWith(::LottoNumber)

        fun from(request: Int): LottoNumber {
            return LOTTO_NUMBERS[request] ?: throw IllegalArgumentException()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}
