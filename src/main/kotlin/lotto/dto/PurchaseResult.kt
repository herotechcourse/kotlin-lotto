package lotto.dto

data class PurchaseResult(
    val userPurchase: UserPurchase,
    val totalTickets: IssuedTickets
)