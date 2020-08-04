fun main(args: Array<String>) {
    val (n, k, q) = readLine()!!.split(' ').map { it.toInt() }
    val p = IntArray(n + 1)
    repeat(q) {
        val a = readLine()!!.toInt()
        p[a]++
    }

    p.slice(1..n)
            .joinToString("\n") { if (k - (q - it) > 0) "Yes" else "No" }
            .let { println(it) }
}

