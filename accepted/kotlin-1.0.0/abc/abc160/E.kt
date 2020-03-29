fun main(args: Array<String>) {
    val (x, y, a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    val p = readLine()!!.split(' ')
            .map { it.toLong() }
            .sortedDescending()
            .take(x)
    val q = readLine()!!.split(' ')
            .map { it.toLong() }
            .sortedDescending()
            .take(y)
    val r = readLine()!!.split(' ')
            .map { it.toLong() }
            .sortedDescending()

    val xs = (p + q).sorted().toLongArray()

    for (i in 0 until c) {
        if (r[i] > xs[i]) {
            xs[i] = r[i]
        } else {
            break
        }
    }

    println(xs.sum())
}
