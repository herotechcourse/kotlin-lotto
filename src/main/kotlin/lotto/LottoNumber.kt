package lotto

class LottoNumber private constructor(private val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val ERROR_MSG = "Value is not in range from $MINIMUM_NUMBER to $MAXIMUM_NUMBER"
        private val NUMBERS: Map<Int, LottoNumber> =
            (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException(ERROR_MSG)
        }
    }
}
