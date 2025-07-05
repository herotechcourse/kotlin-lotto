package lotto.domain

data class LottoTicket(private val lottoNumbers: HashSet<LottoNumber>) {
    init {
        require(lottoNumbers.size == SUFFICIENT_SIZE)
    }

    companion object {
        private const val SUFFICIENT_SIZE = 6

        fun from(requests: Set<Int>): LottoTicket {
            return LottoTicket(
                requests.map { LottoNumber.from(it) }.toHashSet()
            )
        }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ")
    }
}
