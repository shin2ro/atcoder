class Sieve(n: Int) {
    private val f = IntArray(n + 1)

    init {
        f[0] = -1
        f[1] = -1
        for (i in 2..n) {
            if (f[i] > 0) continue
            f[i] = i
            if (i.toLong() * i.toLong() > n) continue
            for (j in i * i..n step i) {
                if (f[j] == 0) f[j] = i
            }
        }
    }

    fun factor(x: Int): MutableMap<Int, Int> {
        val r = mutableMapOf<Int, Int>()
        var x1 = x
        while (x1 != 1) {
            r[f[x1]] = r.getOrElse(f[x1]) { 0 } + 1
            x1 /= f[x1]
        }
        return r
    }
}

fun main() {
    val sieve = Sieve(10000000)
    val n = readLine()!!.toInt()
    var ans = 0L
    for (i in 1..n) {
        var x = 1L
        for ((k, v) in sieve.factor(i)) {
            x *= (v + 1)
        }
        ans += i * x
    }
    println(ans)
}

