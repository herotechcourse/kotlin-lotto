# kotlin-lotto
## Features

### General
- [ ] Wrap primitives
  - [ ] LottoNumber class to wrap an Int
- [ ] Use First-Class-Collections

### Single Lotto Ticket
- [x] List of size SIZE
- [x] Numbers should be between MIN and MAX
- [x] List has unique elements

### Lotto Machine 
- [x] Purchase Amount 
  - [x] Change is calculated for the User
  - [x] Minimum MIN, maximum MAX KRW
- [x] Generates List of Lotto tickets
  - [x] Each ticket is a random set
  - [x] Number of tickets equals purchaseAmount / TICKET_PRICE

### Winning Numbers
- [x] Bonus number in range MIN and MAX
- [x] Bonus number different from winning numbers
- [x] Stores winning numbers as a Lotto ticket

### Calculator
- [x] Count number of matches between Lotto ticket and winning numbers
- [x] Store the Ranks in the Calculator class
  - [x] Map of results
- [x] Calculate return rate

### Lotto Handler - Wrapper Class
- [x] Wrap the input/output handling and lotto game logic
- [x] Reprompt on wrong input
  - [x] Max MAX_RETRY reprompts per input

### Input View and Output View
- [x] Create Input View
- [x] Create Output View

#### Sample Output
```
Please enter the purchase amount.
9876
You have purchased 9 tickets.
[18, 23, 31, 43, 48, 50]
[8, 16, 19, 23, 39, 41]
[3, 13, 14, 21, 23, 26]
[6, 13, 15, 17, 26, 36]
[5, 11, 31, 34, 35, 42]
[3, 4, 11, 33, 35, 37]
[10, 17, 30, 33, 37, 41]
[5, 20, 21, 29, 40, 44]
[3, 32, 34, 37, 38, 43]

Your change is 876 KRW.

Please enter last week’s winning numbers.
3, 32, 34, 37, 38, 1
Please enter the bonus number.
40

Winning Statistics
------------------
3 Matches (5,000 KRW) - 0 tickets
4 Matches (50,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 1 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 Matches (2,000,000,000 KRW) - 0 tickets

Total Earnings 1500000.0 KRW.
Total return rate is 151.88335% (A rate below 1 means a loss).
```

