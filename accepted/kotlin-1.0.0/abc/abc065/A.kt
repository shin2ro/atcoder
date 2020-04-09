fun main(args: Array<String>) {
    val (x, a, b) = readLine()!!.split(' ').map { it.toInt() }
    val ans = when {
        a >= b -> "delicious"
        a + x >= b -> "safe"
        else -> "dangerous"
    }
    println(ans)
}
