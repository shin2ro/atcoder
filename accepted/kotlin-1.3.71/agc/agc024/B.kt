import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val p = (0 until n).map { readLine()!!.toInt() }

    val r = IntArray(n)
    for (i in 0 until n) {
        r[p[i] - 1] = i
    }

    var len = 0
    var l = 1
    for (i in 1 until n) {
        if (r[i - 1] < r[i]) {
            l++
        } else {
            len = max(len, l)
            l = 1
        }
    }
    len = max(len, l)

    println(n - len)
}

