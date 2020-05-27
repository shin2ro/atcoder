fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').let {
        it[0].toInt() to it[1].toLong()
    }
    val a = readLine()!!.split(' ').map { it.toInt() }.sorted().toIntArray()
    val f = readLine()!!.split(' ').map { it.toInt() }.sortedDescending().toIntArray()

    var l = 0L
    var r = 1e12.toLong()
    while (l < r) {
        val x = l + (r - l) / 2

        val s = (0 until n).map { Math.max(a[it] - (x / f[it]), 0) }.sum()

        if (s <= k) {
            r = x
        } else {
            l = x + 1
        }
    }

    println(l)
}
