# kotlin-lotto
## Lotto Machine - Step 2
This LottoMachine is written in Kotlin, simulating actual Lotto machine in real world.
This step extends the Lotto program by supporting manual ticket input.

## Features List Step 2
- [x] Ask the user how many manual tickets they want to enter.
- [x] Read and validate manual ticket numbers from user input.
- [x] Generate the remaining tickets automatically.
- [x] Combine manual and automatic tickets into a full ticket bundle.
- [x] Display how many tickets were manual vs. automatic.
- [x] Display all purchased tickets in order of input.



## Features List Step 1
Acronym descriptions: 
- e. = entity 
- m. = method
- em. = entity + method

Lotto Machine
- [x] e. Need input from user for the amount of money
- [x] e. Need input from user for last week's winning numbers
- [x] e. Need input from user for a bonus number
- [x] e. Has amount of ticket
- [x] m. calculate amount of ticket from the amount of money
- [x] e. Has bundle of tickets
- [x] em. generate LottoTicket objects
- [x] em. generate WinningStatistics object

Lotto Ticket
- [x] e. Ticket has attribute named cost 1,000 KRW
- [x] cost of ticket is an magic number
- [x] e. Ticket has 6 int numbers in array
- [x] Ticket number should be from 1-45
- [x] numbers are not duplicated
- [x] m. numbers are generated randomly

RandomNumberGenerator
- [x] Use `shuffled()` to generate random numbers
- [x] Use `sorted()` to sort numbers in array

WinningStatistics
- [x] e. has count of match --> resultTable in LottoMachine
- [x] e. winning money
- [x] m. calculate winning money
- [x] e. winning ticket(s) --> LottoMachine
- [x] m. calculate winning ticket(s) --> LottoMachine
- [x] e. return rate
- [x] m. calculate return rate

Rank
- [x] Rank is enum class
- [x] e. count of match
- [x] count of match is magic number
- [x] e. winning money
- [x] winning money is magic number

InputView
- [x] User input is dividable by 1000
- [x] msg. `Please enter the purchase amount.`
- [x] msg. `Please enter last week’s winning numbers.`
- [x] msg. `Please enter the bonus number.`

ResultView
- [x] msg. `You have purchased N tickets.`
- [x] msg. `Winning Statistics\n------------------\n`
- [x] msg. `Total return rate is 0.N (A rate below 1 means a loss)`
