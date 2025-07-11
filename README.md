# kotlin-lotto

Functional Requirements
When the user inputs a purchase amount, generate the appropriate number
of Lotto tickets based on that amount.
Each Lotto ticket costs 1,000 KRW.
Draw one additional bonus number for determining the second prize.
Update the winning statistics to include the second prize category.


### Features

#### Lotto
- [x] the amount should be minimum 1,000 KRW
- [x] the amount should be divisible by 1000

- [x] lotto ticket should have 6 numbers
- [x] lotto ticket numbers should be unique
- [x] lotto ticket each number should be between 1 and 45

- [x] generate 6 unique, random, numbers in range 1 to 45
- [x] machine issues lotto tickets with generated numbers
- [ ] machine issues lotto tickets with manuel provided numbers 
- [x] figure out winning tickets

#### Input
- [x] get input of amount
- [x] get the winning numbers
- [x] get the bonus number
- [x] get number of manuel tickets
- [x] get numbers for manuel tickets

#### Output result
- [x] should print the number of purchased tickets
- [x] should print the list of purchased tickets
- [x] should print the result of the game
- [x] should print return rate
