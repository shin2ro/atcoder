import kotlin.math.max
import kotlin.math.min

fun main() {
    val (N, W) = readLine()!!.split(' ').map { it.toInt() }

    val (b, mw, mv) = run {
        var mw = 0
        var mv = 0
        val b = (0 until N).map {
            val (v, w) = readLine()!!.split(' ').map { it.toInt() }
            mw = max(mw, w)
            mv = max(mv, v)
            v to w
        }
        Triple(b, mw, mv)
    }

    val ans = when {
        mw <= 1000 -> {
            val dp = LongArray(W + 1) { 0L }
            for ((v, w) in b) {
                for (i in dp.indices.reversed()) {
                    if (i - w !in dp.indices) continue
                    dp[i] = max(dp[i], dp[i - w] + v)
                }
            }
            dp.max()
        }
        mv <= 1000 -> {
            val inf = 1e9.toLong() * 200 + 1
            val dp = LongArray(mv * N + 1) { inf }
            dp[0] = 0
            for ((v, w) in b) {
                for (i in dp.indices.reversed()) {
                    if (i - v !in dp.indices) continue
                    dp[i] = min(dp[i], dp[i - v] + w)
                }
            }
            dp.withIndex()
                    .filter { (_, w) -> w <= W }
                    .maxBy { (v, _) -> v }!!
                    .index.toLong()
        }
        else -> {
            val dp = mutableMapOf(0L to 0L)
            for ((v, w) in b) {
                val pairs = dp
                        .filter { it.key + w <= W }
                        .map { it.key + w to max(dp[it.key + w] ?: 0, it.value + v) }
                dp.putAll(pairs)
            }
            dp.filter { it.key <= W }
                    .maxBy { it.value }!!
                    .value
        }
    }

    println(ans)
}

