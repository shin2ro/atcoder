fun main() {
    val n = readLine()!!.toInt()
    val c = (0 until n).map { readLine()!!.toInt() }
    var ans = .0
    for (i in 0 until n) {
        val s = (0 until n).count { it != i && c[i] % c[it] == 0 }
        ans += ((s + 2) / 2) / (s + 1.0)
    }
    println(ans)
}

