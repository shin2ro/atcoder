fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(101) { Array(101) { DoubleArray(101) } }
    dp[100][100][100] = 0.0

    for (i in 99 downTo 0) {
        for (j in 99 downTo 0) {
            for (k in 99 downTo 0) {
                val d = (i + j + k).toDouble()
                val x = (dp[i + 1][j][k] + 1) * i / d
                val y = (dp[i][j + 1][k] + 1) * j / d
                val z = (dp[i][j][k + 1] + 1) * k / d
                dp[i][j][k] = x + y + z
            }
        }
    }

    println(dp[a][b][c])
}

