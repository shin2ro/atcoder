fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }

    var ans = IntArray(3) { -1 }

    for (j in 0..1) {
        for (i in 0..n) {
            val k = n - j - i
            if (k >= 0 && i * 2 + j * 3 + k * 4 == m) {
                ans = intArrayOf(i, j, k)
            }
        }
    }

    println(ans.joinToString(" "))
}
