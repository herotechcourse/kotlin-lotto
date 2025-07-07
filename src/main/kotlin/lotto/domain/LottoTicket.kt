package lotto.domain

data class LottoTicket(private val lottoNumbers: HashSet<LottoNumber>) {
    init {
        require(lottoNumbers.size == SUFFICIENT_SIZE)
    }

    companion object {
        private const val SUFFICIENT_SIZE = 6
        const val PRICE_OF_TICKET = 1000
        const val CURRENCY = "KRW"

        fun from(requests: Set<Int>): LottoTicket {
            return LottoTicket(
                requests.sorted().map {
                    LottoNumber.from(it)
                }.toHashSet()
            )
        }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ")
    }
}
