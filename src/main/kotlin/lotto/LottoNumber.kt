package lotto

class LottoNumber private constructor(private val number: Int) {
    companion object {
        const val MIN = 1
        const val MAX = 45
        private val NUMBERS: Map<Int, LottoNumber>
            = (MIN..MAX).associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException("Invalid number. Required range: $MIN..$MAX")
        }
    }
}