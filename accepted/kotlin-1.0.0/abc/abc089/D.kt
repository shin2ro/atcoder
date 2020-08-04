fun main(args: Array<String>) {
    val (h, w, d) = readLine()!!.split(' ').map { it.toInt() }
    val xs = IntArray(h * w + 1)
    val ys = IntArray(h * w + 1)

    for (i in 0 until h) {
        val a = readLine()!!.split(' ').map { it.toInt() }
        for (j in 0 until w) {
            xs[a[j]] = j + 1
            ys[a[j]] = i + 1
        }
    }

    val cs = IntArray(h * w + 1)
    for (r in 1..h * w) {
        if (r - d < 1) {
            cs[r] = 0
            continue
        }
        val l = r - d
        cs[r] = cs[l] + Math.abs(xs[r] - xs[l]) + Math.abs(ys[r] - ys[l])
    }

    val q = readLine()!!.toInt()
    (0 until q)
            .map {
                val (l, r) = readLine()!!.split(' ').map { it.toInt() }
                cs[r] - cs[l]
            }
            .joinToString("\n")
            .let { println(it) }

}

