fun main() {
    val maxN = 1e6.toInt()
    val dp = IntArray(maxN + 1) { -1 }
    dp[1] = 0
    dp[2] = 0
    dp[3] = 1
    for (i in 4..maxN) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        dp[i] %= 10007
    }

    val n = readLine()!!.toInt()
    println(dp[n])
}

