fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 0..n) {
        dp[i][0] = i
    }
    for (i in 0..m) {
        dp[0][i] = i
    }

    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = listOf(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + (if (a[i - 1] == b[j - 1]) 0 else 1)
            ).min()!!
        }
    }

    println(dp[n][m])
}

