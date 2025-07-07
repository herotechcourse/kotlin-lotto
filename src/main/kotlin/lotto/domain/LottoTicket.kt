package lotto.domain

data class LottoTicket(private val lottoNumbers: HashSet<LottoNumber>) {
    init {
        require(lottoNumbers.size == SUFFICIENT_SIZE)
    }

    companion object {
        const val SUFFICIENT_SIZE = 6
        const val PRICE_OF_TICKET = 1000
        const val CURRENCY = "KRW"

        /**
         * LottoTicket does not guarantee sorted order.
         * @param requests must be pre-sorted.
         */
        fun from(requests: Set<Int>): LottoTicket {
            return LottoTicket(
                requests.map {
                    LottoNumber.from(it)
                }.toCollection(linkedSetOf())
            )
        }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ")
    }
}
