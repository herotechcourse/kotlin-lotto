# kotlin-lotto

This LottoMachine is written in Kotlin, simulating actual Lotto machine in real world.

## Our Goals
- Get used to TDD.
- Get used to Kotlin API and JUnit.
- Get used to the pair programming.
- Not get pressure on creating a perfect project, rather make mistake and learn.


## Features List

Lotto Machine
- [x] e. Need input from user for the amount of money
- [x] e. Need input from user for last week's winning numbers
- [x] e. Need input from user for a bonus number
- [x] ~~e. Has amount of ticket~~
- [x] ~~m. calculate amount of ticket from the amount of money~~
- [x] e. Has bundle of tickets
- [x] ~~em. generate LottoTicket objects~~
- [x] em. generate WinningStatistics object
- [x] e. has count of match --> resultTable
- [x] m. calculate winning ticket(s)

Lotto Ticket
- [x] e. Ticket has attribute named cost 1,000 KRW
- [x] cost of ticket is a magic number
- [x] e. Ticket has 6 int numbers in array
- [x] Ticket number should be from 1-45
- [x] numbers are not duplicated

Lotto Printer
- [x] m. numbers in lotto ticket are generated randomly
- [x] Lotto Printer generates auto-numbered lotto tickets

RandomNumberGenerator
- [x] Use `shuffled()` to generate random numbers
- [x] Use `sorted()` to sort numbers in array

WinningStatistics
- [x] e. winning money
- [x] m. calculate winning money
- [x] e. return rate
- [x] m. calculate return rate

Rank
- [x] Rank is enum class
- [x] e. count of match
- [ ] count of match is magic number
- [x] e. winning money
- [ ] winning money is magic number

InputView
- [x] User input is dividable by 1000
- [x] msg. `Please enter the purchase amount.`
- [x] msg. `Enter the number of manual tickets to purchase.`
- [x] msg. `Enter the numbers for manual tickets.`
- [x] msg. `Please enter last week’s winning numbers.`
- [x] msg. `Please enter the bonus number.`
- [x] m. Add re-prompt logic to avoid runtime errors and provide alternative option to user

ResultView
- [x] ~~msg. `You have purchased N tickets.`~~
- [x] msg. `Purchased M manual and N automatic tickets.`
- [x] msg. `Winning Statistics\n------------------\n`
- [x] msg. `Total return rate is 0.N (A rate below 1 means a loss)`

Controller
- [ ] Controller manage direct request and response with `InputView` and `ResultView`
- [ ] Controller interact with managers which are smaller controllers that will controller in separated responsibility

TicketManager
- [ ] manage tickets
- [ ] consolidate manual and auto tickets

ManualTicketManager
- [ ] manage manual tickets
- [ ] create manual tickets

AutoTicketManager
- [ ] manage auto tickets
- [ ] create auto tickets

WinnerManager
- [ ] manage data related with winner numbers and bonus number

StatisticsManager
- [ ] manage data related with stats



## Remindable Ideas

- Create a value object, `LottoTickts` as a wrapper collection of `LottoTicket`
    > "You could create a value object (e.g., LottoTickets) and send it a message like filterTicket()." -- da-nyee
