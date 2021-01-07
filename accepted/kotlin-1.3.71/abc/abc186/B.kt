fun main() {
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val a = (0 until h).map {
        readLine()!!.split(' ').map { it.toInt() }
    }
    val min = a.map { it.min()!! }.min()!!
    var ans = 0
    for (i in 0 until h) {
        for (j in 0 until w) {
            ans += a[i][j] - min
        }
    }
    println(ans)
}

