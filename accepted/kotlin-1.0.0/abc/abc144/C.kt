fun main(args: Array<String>) {
    fun sequence(n: Long): Sequence<Pair<Long, Long>> {
        var i = 1L
        fun f() = generateSequence {
            while (i * i <= n) {
                if (n % i == 0L) {
                    return@generateSequence i to n / i++
                }
                i++
            }
            null
        }
        return f()
    }

    val n = readLine()!!.toLong()
    println(sequence(n).map { it.first + it.second - 2 }.min())
}

