package lotto.exceptions

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

sealed class LottoException(msg: String) : IllegalArgumentException("[ERROR]: $msg") {
    class InvalidAmountFormatException(input: String) : LottoException("Wrong amount format: $input.\n")

    class InvalidAmountException(amount: Int) :
        LottoException(
            "Wrong amount: $amount, " +
                    "Amount should be at least ${LottoTicket.PRICE_OF_TICKET} ${LottoTicket.CURRENCY}" +
                    "and divisible by ${LottoTicket.PRICE_OF_TICKET}.\n",
        )

    class InvalidWinningNumbersFormatException(input: String) :
        LottoException("Invalid winning numbers format: '$input'. Expected numbers separated by commas.")

    class InvalidBonusNumberException(bonusNumber: Int) :
        LottoException(
            "Invalid bonus number format: '$bonusNumber'. " +
                    "Expected a number in the range of ${LottoNumber.MIN_RANGE_NUMBER} " +
                    "to ${LottoNumber.MAX_RANGE_NUMBER} and different to the winning numbers.",
        )
}
