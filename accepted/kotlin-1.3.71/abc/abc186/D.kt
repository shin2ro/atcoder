fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toLong() }.sorted()
    
    val s = LongArray(n + 1)
    for (i in 0 until n) {
        s[i + 1] = s[i] + a[i]
    }

    var ans = 0L
    for (i in 0 until n) {
        ans += s[n] - s[i + 1]
        ans -= (n - i - 1) * a[i]
    }
    println(ans)
}

