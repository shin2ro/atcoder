fun main() {
    val (N, m, T) = readLine()!!.split(' ').map { it.toInt() }
    var n = N
    var t = 0

    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        n = (n - (a - t)).coerceAtLeast(0)
        if (n > 0) {
            n = (n + (b - a)).coerceAtMost(N)
        }
        t = b
    }

    n = (n - (T - t)).coerceAtLeast(0)

    println(if (n > 0) "Yes" else "No")
}

