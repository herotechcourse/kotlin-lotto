package lotto

class InputView {

    val userAmount = "5fgf0"

    fun takeInput(){
        if (userAmount.toIntOrNull() == null ) {
            throw IllegalArgumentException("Input is not a number")
        }
    }

    // Create a test for non-numerical input
}