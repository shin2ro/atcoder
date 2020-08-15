fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val a = (0 until n).map { readLine()!!.toInt() }
    var ans = 0
    var l = 0
    for (r in 1 until n) {
        if (a[r] <= a[r - 1]) {
            ans += (r - l - k + 1).coerceAtLeast(0)
            l = r
        }
    }
    ans += (n - l - k + 1).coerceAtLeast(0)
    println(ans)
}

