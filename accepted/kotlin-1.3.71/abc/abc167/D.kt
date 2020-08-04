fun main() {
    val (n, K) = run {
        val (n, k) = readLine()!!.split(' ').map { it.toLong() }
        n.toInt() to k
    }

    val t = Array(60) { IntArray(n + 1) }
    t[0] = IntArray(1) + readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    for (i in 0 until 59) {
        for (j in 1..n) {
            t[i + 1][j] = t[i][t[i][j]]
        }
    }

    val ans = run {
        var k = K
        var v = 1
        for (i in (0 until 60).reversed()) {
            val l = 1L shl i
            if (l <= k) {
                v = t[i][v]
                k -= l
            }
        }
        v
    }

    println(ans)
}

