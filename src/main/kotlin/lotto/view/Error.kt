package lotto.view

enum class Error(val message: String) {
    BONUS("[ERROR] Bonus number must not be among the winning numbers."),
    LOW_PURCHASE_AMOUNT("[ERROR] The purchase amount must be greater or equal than 1000."),
    NOT_DIVISIBLE_BY_1000("[ERROR] The purchase amount must be divisible by 1,000."),
    INVALID_INPUT("[ERROR] Invalid Input"),
    INVALID_LOTTO_SIZE("[ERROR] Winning numbers must be 6."),
    DUPLICATE_NUMBERS("[ERROR] Numbers must be unique."),
    OUT_OF_RANGE("[ERROR] Numbers must be between 1 and 45."),
    MANUAL_TICKET_NUMBER_TOO_HIGH("[ERROR] Value too high"),
    MANUAL_TICKET_NUMBER_NOT_NULL("[ERROR] Value must be greater or equal to 0"),
}
