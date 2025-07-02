# kotlin-lotto

This LottoMachine is written in Kotlin, simulating actual Lotto machine in real world.

## Our Goals
- Get used to TDD.
- Get used to Kotlin API and JUnit.
- Get used to the pair programming.
- Not get pressure on creating a perfect project, rather make mistake and learn.


## Features List

Lotto Machine
- [ ] e. Need input from user for the amount of money
- [ ] e. Need input from user for last week's winning numbers
- [ ] e. Need input from user for a bonus number
- [ ] e. Has amount of ticket
- [ ] m. calculate amount of ticket from the amount of money
- [ ] e. Has bundle of tickets
- [ ] em. generate LottoTicket objects
- [ ] em. generate WinningStatistics object

Lotto Ticket
- [x] e. Ticket has attribute named cost 1,000 KRW
- [x] cost of ticket is an magic number
- [x] e. Ticket has 6 int numbers in array
- [x] Ticket number should be from 1-45
- [x] numbers are not duplicated
- [ ] m. numbers are generated randomly

RandomNumberGenerator
- [ ] Use `shuffled()` to generate random numbers

RandomTicketGenerator
- [ ] Use RandomNumberGenerator to generate numbers
- [ ] Use `sorted()` to sort numbers in array

WinningStatistics
- [ ] e. has count of match
- [ ] e. winning money
- [ ] m. calculate winning money
- [ ] e. winning ticket(s)
- [ ] m. calculate winning ticket(s)
- [ ] e. return rate
- [ ] m. calculate return rate

Rank
- [ ] Rank is enum class
- [ ] e. count of match
- [ ] count of match is magic number
- [ ] e. winning money
- [ ] winning money is magic number

InputView
- [x] User input is dividable by 1000
- [x] msg. `Please enter the purchase amount.`
- [x] msg. `Please enter last week’s winning numbers.`
- [x] msg. `Please enter the bonus number.`

ResultView
- [ ] msg. `You have purchased N tickets.`
- [ ] msg. `Winning Statistics\n------------------\n`
- [ ] msg. `Total return rate is 0.N (A rate below 1 means a loss)`
