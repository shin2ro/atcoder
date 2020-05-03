import kotlin.math.pow

fun solve(x: Long, n: Long): Pair<Long, Long> {
    for (a in 0L..n) {
        for (b in 0L..n) {
            val a5 = a.toDouble().pow(5).toLong()
            val b5 = b.toDouble().pow(5).toLong()

            if (a5 - b5 == x) return a to b
            if (a5 + b5 == x) return a to -b
        }
    }
    throw Exception("$x $n")
}

fun main() {
    val x = readLine()!!.toLong()
    val (a, b) = solve(x, 1000)
    println("$a $b")
}
