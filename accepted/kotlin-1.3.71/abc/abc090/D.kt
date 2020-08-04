fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    var ans = 0L
    for (b in 1..n) {
        ans += (n / b) * (b - k).coerceAtLeast(0)
        ans += ((n % b) - k + 1).coerceAtLeast(0)
    }
    if (k == 0) {
        ans -= n
    }
    println(ans)
}

