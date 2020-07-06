fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toLong() }
    val list = (0 until n).map {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        a to b
    }.sortedBy { it.first }

    var ans = 0
    var cur = 0L
    for ((a, b) in list) {
        if (cur + b >= k) {
            ans = a
            break
        }
        cur += b
    }

    println(ans)
}
