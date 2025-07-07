package lotto.services

import lotto.domain.Rank
import lotto.domain.WinningCombination
import lotto.dto.IssuedTickets

data class GameResult(
    val issuedTicket: IssuedTickets,
    val winningCombination: WinningCombination,
    val totalAmount: Int,
    val ranks: List<Rank>,
    val returnRate: Double
) {
}