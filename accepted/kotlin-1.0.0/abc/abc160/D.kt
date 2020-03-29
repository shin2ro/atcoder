fun main(args: Array<String>) {
    val (n, x, y) = readLine()!!.split(' ').map { it.toInt() }
    val ans = IntArray(n)
    for (i in 1..n) {
        for (j in i + 1..n) {
            val d = listOf(
                    j - i,
                    Math.abs(x - i) + 1 + Math.abs(y - j),
                    Math.abs(y - i) + 1 + Math.abs(x - j)
            ).min()!!
            ans[d]++
        }
    }
    println(ans.slice(1 until n).joinToString("\n"))
}
