# kotlin-lotto

## [step 1] Features

### Lotto Class

- [x] 6 unique numbers
- [x] in range 1 - 45
- [x] Lotto instance has toString

### WinningNumbers Class

- [x] valid lotto tickets inside winning numbers class
- [x] valid 1 bonus unique number inside winning numbers class

### Rank

- [x] return valid Rank depend on match count, bonus number and if required
- [x] implement valueOf

### Controller

- [x] Add the controller where happen the flow of the app
- [x] Use View classes for input and output
- [x] Create a retry help functions to validate de input and in case of error retry it.
- [x] Create a method or service to create the Lotto tickets
- [x] Create retry helper function to get user input
- [x] Add a generateLottoTickets service

### Services

- [x] add Lotto service
- [x] add Validator for the purchase amount user input
- [x] Add a service to generate the lotto tickets from the amount passed
- [x] minimum ticket: 1000 KRW

### InputView

- [x] Get input
    - [x] Please enter the purchase amount.
    - [x] Please enter last week’s winning numbers.
    - [x] Please enter the bonus number.

### OutputView

- [x] Print out the purchased tickets
- [x] lotto statistics
    - [x] lotto statistics with prices
    - [x] print lotto statistics

### refactors

- [x] create Const value, no magic number
- [x] customize exception for DRY
- [x] add documentation
- [x] separate controller logics
- [x] refactor methods

---


---

## [step 2] Features

### Feedback

#### Application
- [ ] separate `println()` into `OutputView`
- [ ] think/search about what `application` means, and refactor if needed

### Output View
- [ ] collect `const` message and print logic

### Input View 
- [ ] collect `const` message and print logic 

#### Service
- [ ] separate service logic clearly
- [ ] think about why *those functions* should belong to the service layer, and implement a better structure if needed

#### Utils
- [ ] improve naming
- [ ] merge into domain
  - [ ] validate range inside domain logic

#### Refactor
- [ ] fix and clarify condition: `(size == 0 || size == 1)`

### LottoNumber
- [x] wrap `Int` to `LottoNumber`
- [ ] validate itself
  - [x] require: in range (1 ~ 45)
  - [x] require: no duplicated numbers
- [ ] override `equals`, `hashCode` !! still need to understand it
- [ ] implement `from` function
- [x] override `toString`

### LottoTicket
- [ ] wrap `HashSet<LottoNumber>` to `LottoTicket`
- [x] require: sufficient size, 6
- [x] override `toString`

### IssuedTickets
- [ ] wrap `List<LottoTicket>` to `IssuedTickets`

### TicketIssuer
- [ ] implement a flow to issue ticket 
  - get PendingTickets(List<Set<Int>>) → create LottoTickets → return IssuedTickets

### LottoTicketFactory
- [x] implement feature to issue a ticket

### Test
- [ ] add **E2E test**

### todo
- [ ] issue 2 different types:
  - [ ] manual
  - [ ] random