fun main(args: Array<String>) {
    val (n, p) = readLine()!!.split(' ').map { it.toInt() }
    val s = readLine()!!.reversed()

    val ans = if (10 % p == 0) {
        (0 until n)
                .filter { (s[it] - '0') % p == 0 }
                .map { 0L + n - it }
                .sum()
    } else {
        val d = IntArray(n + 1)
        var b = 1
        for (i in 0 until n) {
            val x = (s[i] - '0') * b % p
            d[i + 1] = (d[i] + x) % p
            b = b * 10 % p
        }

        val cnt = IntArray(p)
        (0..n).map { 0L + cnt[d[it]]++ }.sum()
    }

    println(ans)
}
