import kotlin.math.max
import kotlin.math.min

fun List<Pair<Long, Long>>.lowerBound(element: Pair<Long, Long>): Int {
    return this
        .binarySearch {
            when {
                it.first > element.first -> 1
                it.first < element.first -> -1
                else -> if (it.second >= element.second) 1 else -1
            }
        }
        .let { -(it + 1) }
}

fun main() {
    val (N, W) = readLine()!!.split(' ').map { it.toInt() }
    val (items, mw, mv) = run {
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
        N <= 30 -> {
            val n = N / 2
            val ps = run {
                val ps = Array<Pair<Long, Long>?>(1 shl n) { null }
                for (i in 0 until (1 shl n)) {
                    var sv = 0L
                    var sw = 0L
                    for (j in 0 until n) {
                        if (i shr j and 1 == 1) {
                            val (v, w) = items[j]
                            sv += v
                            sw += w
                        }
                    }
                    ps[i] = sw to sv
                }
                ps.sortBy { it!!.first }
                var m = 1
                for (i in 1 until (1 shl n)) {
                    if (ps[m - 1]!!.second < ps[i]!!.second) {
                        ps[m++] = ps[i]
                    }
                }
                ps.slice(0 until m).map { it!! }
            }
            var res = 0L
            for (i in 0 until (1 shl N - n)) {
                var sv = 0L
                var sw = 0L
                for (j in 0 until N - n) {
                    if (i shr j and 1 == 1) {
                        val (v, w) = items[n + j]
                        sv += v
                        sw += w
                    }
                }
                if (sw <= W) {
                    val (_, v) = ps[ps.lowerBound(W - sw to Long.MAX_VALUE) - 1]
                    res = max(res, sv + v)
                }
            }
            res
        }
        mw <= 1000 -> {
            val dp = LongArray(W + 1) { 0L }
            for ((v, w) in items) {
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
            for ((v, w) in items) {
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
        else -> throw Exception()
    }
    println(ans)
}

