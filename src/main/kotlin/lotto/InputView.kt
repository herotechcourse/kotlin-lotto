package lotto

class InputView {
    val validator = Validator()

    fun takePurchaseInput() : Int{

        while(true){
            try{
                println("Please enter the purchase amount.")
                val input = readln()
                validator.validateAmount(input)
                return input.toInt()
            } catch (e : IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeWinningNumbers() : List<String> {
        while(true){
            try{
                println("Please enter last week's winning numbers.")
                val input = readln().split(",")
                input.forEach { item -> item.trim() }
                validator.validateWinningNumbers(input)
                return input
            } catch (e : IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun takeBonusNumber(winningNumbers: List<String>) : Int {
        while(true) {
            try{
                println("Please enter the bonus number.")
                val bonusInput = readln()
                validator.validateBonusNumber(bonusInput, winningNumbers)
                return bonusInput.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}