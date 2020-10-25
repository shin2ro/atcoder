fun main() {
    val mod = 998244353L
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val ranges = (0 until k).map {
        val (l, r) = readLine()!!.split(' ').map { it.toInt() }
        l to r + 1
    }

    val dp = LongArray(n)
    dp[0] = 1

    for (i in 0 until n) {
        if (i > 1) {
            dp[i] += dp[i - 1] + mod
            dp[i] %= mod
        }
        for ((l, r) in ranges) {
            if (i + l < n) {
                dp[i + l] += dp[i]
                dp[i + l] %= mod
            }
            if (i + r < n) {
                dp[i + r] -= dp[i] + mod
                dp[i + r] %= mod
            }
        }
    }

    println(dp[n - 1])
}

