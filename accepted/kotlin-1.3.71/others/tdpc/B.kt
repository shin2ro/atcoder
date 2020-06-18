import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = readLine()!!.split(' ').map { it.toInt() }

    val inf = Int.MAX_VALUE
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in n downTo 0) {
        for (j in m downTo 0) {
            if (i == n && j == m) continue

            if ((i + j) % 2 == 0) {
                val x1 = if (j < m) dp[i][j + 1] + b[j] else 0
                val x2 = if (i < n) dp[i + 1][j] + a[i] else 0
                dp[i][j] = max(x1, x2)
            } else {
                val x1 = if (j < m) dp[i][j + 1] else inf
                val x2 = if (i < n) dp[i + 1][j] else inf
                dp[i][j] = min(x1, x2)
            }
        }
    }

    println(dp[0][0])
}
