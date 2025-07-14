package lotto

object Generator {
    fun randomNumber() = (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER).shuffled().take(6)
}
