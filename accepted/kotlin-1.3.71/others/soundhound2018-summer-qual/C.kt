fun main() {
    val (n, m, d) = readLine()!!.split(' ').map { it.toInt() }
    val ans = if (d == 0) {
        1.0 / n * (m - 1)
    } else {
        2.0 * (n - d) / n / n * (m - 1)
    }
    println(ans)
}

