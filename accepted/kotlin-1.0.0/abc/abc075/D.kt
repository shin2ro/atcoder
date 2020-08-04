fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val xs = IntArray(n)
    val ys = IntArray(n)
    for (i in 0 until n) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }
        xs[i] = x
        ys[i] = y
    }

    var ans = 1L shl 62

    for (xi in 0 until n) {
        for (xj in 0 until n) {
            for (yi in 0 until n) {
                for (yj in 0 until n) {
                    val xl = xs[xi]
                    val xr = xs[xj]
                    val yb = ys[yi]
                    val yt = ys[yj]
                    if (!(xl < xr && yb < yt)) continue

                    val cnt = (0 until n).count { xs[it] in xl..xr && ys[it] in yb..yt }
                    if (cnt >= k) {
                        ans = Math.min(1L * (xr - xl) * (yt - yb), ans)
                    }
                }
            }
        }
    }

    println(ans)
}

