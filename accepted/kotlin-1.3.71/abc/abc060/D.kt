fun main() {
    val (n, mw) = readLine()!!.split(' ').map { it.toInt() }
    val xs = (0 until n).map {
        val (w, v) = readLine()!!.split(' ').map { it.toInt() }
        w to v
    }

    val w0 = xs[0].first

    val map = Array(4) { mutableListOf<Int>() }
    for (i in 0 until n) {
        val j = xs[i].first - w0
        val v = xs[i].second
        map[j].add(v)
    }

    for (i in 0 until 4) {
        map[i].sortDescending()
    }

    fun dfs(cur: Int, tw: Int, tv: Int): Int {
        if (cur == 4) return tv

        var w = tw
        var v = tv

        var r = dfs(cur + 1, w, v)

        for (i in map[cur].indices) {
            if (w + w0 + cur > mw) break
            w += w0 + cur
            v += map[cur][i]
            r = r.coerceAtLeast(dfs(cur + 1, w, v))
        }

        return r
    }

    println(dfs(0, 0, 0))
}

