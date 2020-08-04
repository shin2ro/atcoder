fun main() {
    val mod = 1e9.toLong() + 7
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    var ans = 0L
    for (i in k..n + 1L) {
        val min = i * (i - 1) / 2
        val max = i * (n + n - i + 1) / 2
        ans += max - min + 1
        ans %= mod
    }
    println(ans)
}

