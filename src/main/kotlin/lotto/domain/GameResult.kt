package lotto.domain

import lotto.dto.IssuedTickets

data class GameResult(
    val issuedTicket: IssuedTickets,
    val winningCombination: WinningCombination,
    val totalAmount: Int,
    val ranks: List<Rank>,
    val returnRate: Double
)