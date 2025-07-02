package lotto

class Lotto (val lottoNumbers: List<Int>) {
    init {
        require(lottoNumbers.count() == 6)
    }

    fun getNumbers() : List<Int>{
        return lottoNumbers
    }
}