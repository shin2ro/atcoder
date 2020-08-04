fun main() {
    val n = readLine()!!.toInt()
    val r = readLine()!!.split(' ').map { it.toInt() }

    var ans = 1
    var d = 0
    for (i in 1 until n) {
        if (r[i] > r[i - 1]) {
            if (d != 1) ans++
            d = 1
        }

        if (r[i] < r[i - 1]) {
            if (d != -1) ans++
            d = -1
        }
    }

    println(if (ans >= 3) ans else 0)
}

