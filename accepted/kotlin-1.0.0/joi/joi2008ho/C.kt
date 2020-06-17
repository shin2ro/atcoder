fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }

    val p1 = IntArray(n + 1)
    repeat(n) {
        p1[it] = readLine()!!.toInt()
    }

    val p2 = IntArray(p1.size * p1.size)
    for (i in p1.indices) {
        for (j in p1.indices) {
            p2[i * p1.size + j] = p1[i] + p1[j]
        }
    }
    p2.sort()

    var ans = 0
    for (i in p1.indices) {
        for (j in p1.indices) {
            val p = p1[i] + p1[j]
            if (p > m) continue
            val k = p2.binarySearch(m - p)
            ans = if (k >= 0) {
                Math.max(p + p2[k], ans)
            } else {
                Math.max(p + p2[-k - 2], ans)
            }
        }
    }
    println(ans)
}
