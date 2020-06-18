fun main() {
    val (h, n) = readLine()!!.split(' ').map { it.toInt() }
    val ms = (0 until n).map {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        a to b
    }
    val dp = IntArray(h + 1) { 1e9.toInt() }
    dp[h] = 0
    for (i in h downTo 0) {
        for (j in 0 until n) {
            val (a, b) = ms[j]
            val ni = (i - a).coerceAtLeast(0)
            dp[ni] = dp[ni].coerceAtMost(dp[i] + b)
        }
    }
    println(dp[0])
}
