fun main(args: Array<String>) {
    val (n, k, c) = readLine()!!.split(' ').map { it.toInt() }
    val s = readLine()!!

    fun f(s: String): List<Int> {
        val r = mutableListOf<Int>()
        var i = 0
        while (i < n && r.size < k) {
            if (s[i] == 'o') {
                r.add(i)
                i += c + 1
            } else {
                i++
            }
        }
        return r
    }

    val l = f(s).toIntArray()
    val r = f(s.reversed()).map { n - 1 - it }.reversed().toIntArray()

    (0 until k)
            .map { if (l[it] == r[it]) l[it] + 1 else 0 }
            .filter { it > 0 }
            .joinToString("\n")
            .let { println(it) }
}

