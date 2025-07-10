package lotto

@JvmInline
value class PurchaseAmount(val amount: Int) {
    init {
        require(amount in MIN..MAX) { "Purchase amount must be between $MIN and $MAX" }
    }

    companion object {
        private const val MIN = 1_000
        private const val MAX = 20_000
    }
}
