# kotlin-lotto

## Features

- [x] Purchase amount validation (Greater or equal than 1000, divisible by 1000)
    - [x] The input amount must be greater than or equal to 1,000 KRW
    - [x] The amount must be divisible by 1,000 KRW
- [x] Calculate number of tickets from the amount: amount / 1000

- [x] validate the number of manual tickets to purchase:
    - [x] number must be greater then 0
    - [x] number must lower than number of tickets
- [x] calculate number of ticket user want to manually generate
- [x] calculate number of tickets the machine has to automatically generate
- [x] Display number of manual and automatic tickets
- [x] Input and Validation numbers for manual tickets:
    - [x] each ticket has 6 numbers
    - [x] Numbers must be in the range 1 to 45

- [ ] Generate automatic LottoTickets
    - [x] each ticket has 6 numbers
    - [x] Numbers must be in the range 1 to 45
    - [x] Numbers should be sorted in ascending order
    - [x] Display all purchased tickets to the user

- [x] Input and Validation winning numbers:
    - [x] Input 6 unique winning numbers (1–45)
    - [x] Input 1 bonus number (must not be among the 6 winning numbers)
- [x] Match tickets against winning numbers
    - [x] Compare each ticket against the winning numbers
    - [x] Count how many numbers match (include bonus number for 2nd prize)
- [x] Determine prize rank using Enum class
- [x] Show winning statistic
    - [x] Count and display how many tickets fall into each prize category
    - [x] Calculate and display winning rate

## Functional Requirements

- Allow users to manually enter Lotto numbers in addition to automatically generated ones.
- Accept input for the purchase amount, the number of manually generated tickets, and their respective numbers.
- Use First-Class Collections to encapsulate sets of Lotto numbers. For example, create a LottoNumber class to wrap a
  single Int value.
