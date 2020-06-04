fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = readLine()!!.split(' ').map { it.toInt() }

    var cnt = 0L
    for (i in 0 until n) {
        if (a[i] < b[i]) cnt += (b[i] - a[i]) / 2
        if (a[i] > b[i]) cnt -= (a[i] - b[i])
    }
    println(if (cnt >= 0L) "Yes" else "No")
}
