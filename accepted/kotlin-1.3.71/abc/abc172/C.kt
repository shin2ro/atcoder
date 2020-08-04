import kotlin.math.max

fun main() {
    val (n, m, k) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = readLine()!!.split(' ').map { it.toInt() }

    val sa = LongArray(n + 1)
    val sb = LongArray(m + 1)

    for (i in 0 until n) {
        sa[i + 1] = sa[i] + a[i]
    }

    for (i in 0 until m) {
        sb[i + 1] = sb[i] + b[i]
    }

    var ans = 0

    for (i in 0..n) {
        if (sa[i] > k) continue
        val j = sb.binarySearch(k - sa[i])
        if (j < 0) {
            ans = max(i - (j + 1) - 1, ans)
        } else {
            ans = max(i + j, ans)
        }
    }

    println(ans)
}

