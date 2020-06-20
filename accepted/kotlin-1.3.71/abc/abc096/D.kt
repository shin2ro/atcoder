fun main() {
    val n = readLine()!!.toInt()

    fun sieve(n: Int): List<Int> {
        val xs = BooleanArray(n + 1) { true }
        var i = 2
        while (i * i <= n) {
            if (xs[i]) {
                for (j in i + i..n step i) {
                    xs[j] = false
                }
            }
            i++
        }
        return (2..n).filter { xs[it] }
    }

    val primes = sieve(55555)
    println(primes.filter { it % 5 == 1 }.take(n).joinToString(" "))
}
