fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val ans = when {
        a + b == 15 -> "+"
        a * b == 15 -> "*"
        else -> "x"
    }
    println(ans)
}
