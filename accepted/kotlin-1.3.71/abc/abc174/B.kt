fun main() {
    val (n, d) = readLine()!!.split(' ').map { it.toInt() }
    val d2 = 1L * d * d
    val ans = (0 until n).count {
        val (x, y) = readLine()!!.split(' ').map { it.toLong() }
        x * x + y * y <= d2
    }
    println(ans)
}

