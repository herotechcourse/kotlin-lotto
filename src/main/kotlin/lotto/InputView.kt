package lotto

class InputView {

    fun takePurchaseInput() : Int{

        while(true){
            try{
                println("Please enter the purchase amount.")
                val input = readln()
                val validator = Validator()
                validator.validateAmount(input)
                return input.toInt()
            } catch (e : IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    // Create a test for non-numerical input
}