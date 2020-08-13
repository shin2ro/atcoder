import kotlin.math.max

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val s = (0 until n).map { readLine()!!.toInt() }

    var ans = 0
    var x = 1L
    var l = 0

    for (r in 1..n) {
        x *= s[r - 1]
        if (x <= k) {
            ans = max(ans, r - l)
            continue
        }

        while (l < r && x > k) {
            x /= s[l++]
        }
    }

    println(if (x == 0L) n else ans)
}

