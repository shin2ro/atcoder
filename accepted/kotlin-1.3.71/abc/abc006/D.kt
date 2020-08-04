fun <T> List<T>.lowerBound(element: T): Int where T : Comparable<T> {
    return this
            .binarySearch { if (it >= element) 1 else -1 }
            .let { -(it + 1) }
}

const val INF = 100000

fun main() {
    val n = readLine()!!.toInt()
    val cards = (0 until n).map { readLine()!!.toInt() }
    val dp = IntArray(n) { INF }.toMutableList()

    for (i in 0 until n) {
        val j = dp.lowerBound(cards[i])
        dp[j] = cards[i].coerceAtMost(dp[j])
    }

    println(n - dp.lowerBound(INF))
}

