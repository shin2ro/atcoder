fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val logs = readLine()!!.split(' ').map { it.toInt() }
    var l = 1
    var r = logs.max()!!
    while (l < r) {
        val x = l + (r - l) / 2
        val s = logs.sumBy { (it + x - 1) / x - 1 }
        if (s <= k) {
            r = x
        } else {
            l = x + 1
        }
    }
    println(l)
}

