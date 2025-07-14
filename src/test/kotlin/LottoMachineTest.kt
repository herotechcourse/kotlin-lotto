package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `ticket should contain 6 numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createGeneratedTickets(1, 0)
        val numbersInTicket = tickets[0].lottoNumbersAsInt
        assertEquals(
            6,
            numbersInTicket.count(),
            "Ticket numbers aren't 6",
        )
    }

    @Test
    fun `amount of tickets were generated`() {
        val lottoMachine = LottoMachine()
        assertEquals(
            2,
            lottoMachine.createGeneratedTickets(4, 2).count(),
            "Amount of tickets is different then expected",
        )
    }

    @Test
    fun `correct amount of rate is calculated`() {
        val lottoMachine = LottoMachine()
        val results = mutableMapOf<Rank, Int>()
        results[Rank.FIFTH] = 1
        val amount = 3000
        assertEquals(
            2.toBigDecimal(),
            lottoMachine.calculateReturnRate(results, amount),
            "Rate result is different than expected",
        )
    }

    @Test
    fun `correct amount of rate is calculated for the FIRST prize`() {
        val lottoMachine = LottoMachine()
        val lottoNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )

        val results =
            lottoMachine.compareTickets(
                listOf(
                    Lotto(lottoNumbers),
                    Lotto(lottoNumbers),
                    Lotto(
                        listOf(
                            LottoNumber(10),
                            LottoNumber(20),
                            LottoNumber(30),
                            LottoNumber(40),
                            LottoNumber(41),
                            LottoNumber(42),
                        ),
                    ),
                ),
                winningNumber = listOf("1", "2", "3", "4", "5", "6"),
                bonusNumber = 9,
            )

        assertEquals(
            1333333.toBigDecimal(),
            lottoMachine.calculateReturnRate(results, 3000),
            "Rate result is different than expected",
        )
    }
}
