fun main() {
    val n = readLine()!!.last() - '0'
    val ans = when {
        listOf(2, 4, 5, 7, 9).contains(n) -> {
            "hon"
        }
        listOf(0, 1, 6, 8).contains(n) -> {
            "pon"
        }
        else -> {
            "bon"
        }
    }
    println(ans)
}
