# kotlin-lotto
## Features
### Single Lotto Ticket
- [x] List of size 6
- [x] Numbers should be between 0 and 50
- [x] List has unique elements

### Purchase Amount
- [x] Minimum 1_000, (maximum 20_000 KRW)

### Entered Ticket Count
- [x] Must be a positive number

### Ticket Counter
- [x] Entered Ticket count should be less than Purchasable tickets
- [x] Number of tickets equals purchaseAmount / 1000
- [x] Automatic ticket count equals Purchasable Tickets - Entered Ticket Count

### Lotto Machine 
- [x] Change
  - [x] Change is calculated for the User
- [x] Generates List of automatic Lotto tickets
  - [x] Each ticket is a random set

### Winning Numbers
- [x] Bonus number in range 0 and 50
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
  - [x] Max 5 reprompts per input

### Input View and Output View
- [x] Create Input View
- [x] Create Output View

### Lotto Number
- [x] Must be between 0 and 45

#### Sample Output
```

Please enter the purchase amount.
9876

Enter the number of manual tickets to purchase.
3

Enter the numbers for manual tickets.
8, 21, 23, 41, 42, 43
Enter the numbers for manual tickets.
3, 5, 11, 16, 32, 38
Enter the numbers for manual tickets.
7, 11, 16, 35, 36, 44

Purchased 3 manual and 6 automatic tickets.
[15, 23, 25, 28, 40, 44]
[6, 14, 18, 30, 33, 35]
[1, 4, 11, 19, 27, 38]
[25, 27, 35, 36, 38, 45]
[5, 13, 15, 38, 39, 44]
[2, 7, 18, 32, 33, 44]
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]

Your change is 876 KRW.

Please enter last week’s winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
------------------
6 Matches (2,000,000,000 KRW) - 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 0 tickets
4 Matches (50,000 KRW) - 0 tickets
3 Matches (5,000 KRW) - 0 tickets
Total Earnings 0.0 KRW.
Total return rate is 0.0% (A rate below 1 means a loss).

```

