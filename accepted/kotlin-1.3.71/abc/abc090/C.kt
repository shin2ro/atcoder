fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toLong() }
    println((if (n == 1L) 1 else n - 2) * (if (m == 1L) 1 else m - 2))
}

