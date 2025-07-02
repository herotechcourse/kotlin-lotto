package lotto

class Validator {

    fun validateAmount(userAmount: Int?){
        if (userAmount == null) {
            throw IllegalArgumentException("Input is not a number")
        }
        if ((userAmount % 1000) != 0 ) {
            throw IllegalArgumentException("Input is not multiple of 1000")
        }
    }

}