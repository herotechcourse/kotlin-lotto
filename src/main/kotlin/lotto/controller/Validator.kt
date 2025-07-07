package lotto.controller

import lotto.domain.LottoTicket

object Validator {
    fun amount(amount: Int) {
        require(amount >= 0) { "Amount must be non-negative" }
        require(amount >= LottoTicket.PRICE_OF_TICKET) { "Amount should able to purchase at least 1 ticket" }
        require(amount % LottoTicket.PRICE_OF_TICKET == 0) { "Amount should dividable" }
    }
}