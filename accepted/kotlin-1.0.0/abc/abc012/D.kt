fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val table = Array(n) { IntArray(n) { 1000000 } }
    for (i in 0 until n) {
        table[i][i] = 0
    }
    repeat(m) {
        val (a, b, t) = readLine()!!.split(' ').map { it.toInt() }
        table[a - 1][b - 1] = t
        table[b - 1][a - 1] = t
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                table[i][j] = Math.min(table[i][k] + table[k][j], table[i][j])
            }
        }
    }
    var ans = Int.MAX_VALUE
    for (i in 0 until n) {
        ans = Math.min(table[i].max()!!, ans)
    }
    println(ans)
}
