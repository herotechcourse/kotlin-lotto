package lotto

import lotto.model.LottoPrinter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPrinterTest {
    @ParameterizedTest(name = "is LottoPrinter generate {0} number of lotto tickets")
    @ValueSource(ints = [1, 2, 3, 14, 25, 35])
    fun `LottoPrinter generate auto-numbered lotto tickets based on the number of tickets as a input`(candidate: Int) {
        val tickets = LottoPrinter.generateAutoLottoTickets(candidate)
        assertEquals(candidate, tickets.asList().size)
    }
}
