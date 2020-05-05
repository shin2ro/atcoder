fun main() {
    val (n, m, q) = readLine()!!.split(' ').map { it.toInt() }
    val qs = (0 until q).map { readLine()!!.split(' ').map { it.toInt() } }

    fun dfs(xs: List<Int>): Int {
        if (xs.size == n + 1) {
            return qs.map { (a, b, c, d) -> if (xs[b] - xs[a] == c) d else 0 }.sum()
        }
        return (xs.last()..m).map { dfs(xs + it) }.max()!!
    }

    println(dfs(listOf(1)))
}
