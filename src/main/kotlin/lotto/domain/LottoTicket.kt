package lotto.domain

data class LottoTicket(private val lottoNumbers: HashSet<LottoNumber>) {
    init {
        require(lottoNumbers.size == SUFFICIENT_SIZE)
    }

    companion object {
        private const val SUFFICIENT_SIZE = 6
    }
}
