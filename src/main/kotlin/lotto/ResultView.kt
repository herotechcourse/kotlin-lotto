package lotto

class ResultView() {

    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.count()} tickets.")
        lottos.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            println(lottoNumbers.joinToString(",", "[", "]"))
        }
    }
}
