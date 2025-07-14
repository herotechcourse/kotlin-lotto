package controller

import lotto.LottoMachine
import lotto.LottoNumbers
import lotto.Money
import lotto.PurchaseResult

object PurchaseService {
    fun purchase(
        amountInput: Int,
        manualTickets: List<LottoNumbers>,
    ): PurchaseResult {
        val money = Money.of(amountInput)
        money.canPurchaseTickets(manualTickets.size)

        val lottoMachine = LottoMachine(money, manualTickets)

        return PurchaseResult(
            money = money,
            tickets = lottoMachine.provideTickets(),
            manualCount = manualTickets.size,
        )
    }
}
