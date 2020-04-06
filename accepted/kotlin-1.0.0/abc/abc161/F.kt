fun main(args: Array<String>) {
    val n = readLine()!!.toLong()

    fun f(n: Long): List<Long> {
        val r = mutableListOf<Long>()
        var i = 1L
        while (i * i <= n) {
            if (n % i == 0L) {
                r.add(i)
                if (i * i != n) r.add(n / i)
            }
            i++
        }
        return r
    }

    var ans = 0

    for (l in f(n)) {
        if (l == 1L) continue
        var x = n
        while (x % l == 0L) x /= l
        if (x % l == 1L) ans++
    }

    ans += f(n - 1).size - 1

    println(ans)
}
