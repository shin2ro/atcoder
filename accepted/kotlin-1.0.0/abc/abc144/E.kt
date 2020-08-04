fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').let {
        it[0].toInt() to it[1].toLong()
    }
    val a = readLine()!!.split(' ').map { it.toInt() }.sorted().toIntArray()
    val f = readLine()!!.split(' ').map { it.toInt() }.sortedDescending().toIntArray()

    var l = 0L
    var r = 1e12.toLong()
    while (l < r) {
        val m = l + (r - l) / 2

        var x = 0L
        for (i in 0 until n) {
            x += Math.max(a[i] - (m / f[i]), 0)
        }

        if (x <= k) {
            r = m
        } else {
            l = m + 1
        }
    }

    println(l)
}

