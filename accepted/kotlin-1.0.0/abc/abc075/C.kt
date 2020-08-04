fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val edges = mutableListOf<Pair<Int, Int>>()
    val g = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        edges.add(a to b)
        g[a].add(b)
        g[b].add(a)
    }

    fun dfs(i: Int): Boolean {
        val (a, b) = edges[i]
        val visited = BooleanArray(n + 1) { false }

        fun rec(u: Int) {
            visited[u] = true
            for (v in g[u]) {
                if (visited[v]) continue
                if (u == a && v == b) continue
                rec(v)
            }
        }

        rec(a)

        return !visited[b]
    }

    println((0 until m).count { dfs(it) })
}

