package lotto.util

import lotto.exceptions.LottoException

object LottoUtils {
    /**
     * @exception LottoException throw only one of LottoException
     */
    fun requireOrThrow(
        condition: Boolean,
        exception: LottoException,
    ) {
        if (!condition) {
            throw exception
        }
    }
}
