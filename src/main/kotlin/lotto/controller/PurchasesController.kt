package lotto.controller

import lotto.dto.PurchaseResult
import lotto.dto.UserPurchase

object PurchasesController {
    fun getPurchaseResult(): PurchaseResult {
        val userPurchase = getUserPurchases()
        return PurchaseResult(userPurchase)
    }

    private fun getUserPurchases(): UserPurchase {
        val amount = Prompter.askAmount()
        val manualTicketsCount = Prompter.askManualTicketsNumbers(amount)
        return UserPurchase(amount, manualTicketsCount)
    }
}
