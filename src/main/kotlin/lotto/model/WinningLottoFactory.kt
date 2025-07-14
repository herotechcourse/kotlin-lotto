package lotto.model

object WinningLottoFactory {
    fun from(
        listOfInt: Set<Int>,
        bonusNumber: LottoNumber,
    ): WinningLotto {
        return WinningLotto(Lotto.fromInts(listOfInt), bonusNumber)
    }
}
