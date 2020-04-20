import kotlin.math.abs
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toLong() }
    val b = a.mapIndexed { i, l -> i to l }.sortedByDescending { it.second }.map { it.first }.toIntArray()
    val dp = Array(n + 1) { LongArray(n + 1) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i + j == n) break
            val idx = b[i + j]
            dp[i][j + 1] = max(dp[i][j] + a[idx] * abs(idx - j), dp[i][j + 1])
            dp[i + 1][j] = max(dp[i][j] + a[idx] * abs(n - 1 - idx - i), dp[i + 1][j])
        }
    }

    (0 until n)
            .map { dp[it][n - it] }
            .max()
            .let { println(it) }
}
