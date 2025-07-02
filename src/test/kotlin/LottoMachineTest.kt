package lotto

import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals


class LottoMachineTest {

    @Test
    fun `should return right amount of tickets`(){
        val lottoMachine = LottoMachine(5000)
        assertEquals( "Amount isn't a multiple of 1000", lottoMachine.calculateTickets(), 5)
    }


}