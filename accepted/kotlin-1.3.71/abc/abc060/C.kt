fun main() {
    val (n, t) = readLine()!!.split(' ').map { it.toInt() }
    val ts = readLine()!!.split(' ').map { it.toInt() }

    var ans = 0L
    for (i in 1 until n) {
        ans += (ts[i] - ts[i - 1]).coerceAtMost(t)
    }
    ans += t
    println(ans)
}

