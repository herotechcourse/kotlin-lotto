package lotto.dto

data class PendingTicket(val numbers: Set<Int>)

data class PendingTickets(val requests: List<PendingTicket>)