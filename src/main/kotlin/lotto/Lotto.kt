package lotto

class Lotto (lottoNumbers: List<Int>) {
    init {
        require(lottoNumbers.count() == 6)
    }
}