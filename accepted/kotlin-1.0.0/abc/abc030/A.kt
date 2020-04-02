fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split(' ').map { it.toInt() }
    val x = b * c
    val y = d * a

    val ans = when {
        x > y -> "TAKAHASHI"
        x < y -> "AOKI"
        else -> "DRAW"
    }

    println(ans)
}
