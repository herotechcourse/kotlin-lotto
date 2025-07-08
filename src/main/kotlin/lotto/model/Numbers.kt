package lotto.model

data class Numbers(val numbers: List<Int>) : List<Int> {
    override val size: Int get() = numbers.size

    init {
        require(numbers.isNotEmpty()) { "Numbers must not be empty" }
        require(numbers.all { it >= LottoTicket.MIN_LOTTO_NUMBER && it <= LottoTicket.MAX_LOTTO_NUMBER }) {
            "Numbers must be in range [${LottoTicket.MIN_LOTTO_NUMBER}, ${LottoTicket.MAX_LOTTO_NUMBER}]"
        }
        require(numbers.size == LottoTicket.SIZE_OF_NUMBERS) { "Size of numbers should be $LottoTicket.SIZE_OF_NUMBERS" }
        require(numbers.toSet().size == numbers.size) { "Numbers must not be duplicated" }
    }

    override fun get(index: Int): Int = numbers[index]

    override fun contains(element: Int): Boolean = numbers.contains(element)

    override fun containsAll(elements: Collection<Int>): Boolean = numbers.containsAll(elements)

    override fun indexOf(element: Int): Int = numbers.indexOf(element)

    override fun isEmpty(): Boolean = numbers.isEmpty()

    override fun iterator(): Iterator<Int> = numbers.iterator()

    override fun lastIndexOf(element: Int): Int = numbers.lastIndexOf(element)

    override fun listIterator(): ListIterator<Int> = numbers.listIterator()

    override fun listIterator(index: Int): ListIterator<Int> = numbers.listIterator(index)

    override fun subList(
        fromIndex: Int,
        toIndex: Int,
    ): List<Int> = numbers.subList(fromIndex, toIndex)
}
