import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val cities = (0 until n).map {
        val (x, y, z) = readLine()!!.split(' ').map { it.toInt() }
        Triple(x, y, z)
    }

    val costs = Array(n) { IntArray(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue
            val (a, b, c) = cities[i]
            val (p, q, r) = cities[j]
            costs[i][j] = abs(p - a) + abs(q - b) + max(0, r - c)
        }
    }

    val m = 1 shl n
    val dp = Array(m) { IntArray(n) { Int.MAX_VALUE } }

    for (i in 1 until n) {
        dp[1 shl i][i] = costs[0][i]
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i shr j and 1 != 1) continue
            for (k in 0 until n) {
                if (i shr k and 1 == 1) continue
                dp[i or (1 shl k)][k] = min(dp[i or (1 shl k)][k], dp[i][j] + costs[j][k])
            }
        }
    }

    println(dp[m - 1][0])
}

