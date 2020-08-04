import kotlin.math.min

fun main() {
    val (n, m, x) = readLine()!!.split(' ').map { it.toInt() }
    val books = (0 until n).map { readLine()!!.split(' ').map { it.toInt() } }
    var ans = -1
    for (bits in (0 until (1 shl n))) {
        var cost = 0
        val a = IntArray(m)
        for (i in 0 until n) {
            if ((bits shr i) and 1 == 1) {
                cost += books[i][0]
                for (j in 0 until m) {
                    a[j] += books[i][j + 1]
                }
            }
        }

        if (a.all { it >= x }) {
            ans = if (ans == -1) cost else min(cost, ans)
        }
    }
    println(ans)
}

