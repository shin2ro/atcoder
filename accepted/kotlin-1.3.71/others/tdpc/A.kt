fun main() {
    val m = 100 * 100
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(n + 1) { BooleanArray(m + 1) { false } }
    dp[0][0] = true
    for (i in 0 until n) {
        for (j in 0..m) {
            if (dp[i][j]) {
                dp[i + 1][j] = true
                dp[i + 1][j + p[i]] = true
            }
        }
    }
    println(dp.last().count { it })
}

