package lotto.factory

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object TicketMachine {

    fun issueTicket(numbers: Set<Int>): LottoTicket {
        val lottoNumbers = numbers.map { LottoNumber.from(it) }.toSet()
        return LottoTicket(lottoNumbers.toHashSet())
    }
}