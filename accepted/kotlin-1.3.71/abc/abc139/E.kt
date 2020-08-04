import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val t = Array(n) { IntArray(n - 1) }
    for (i in 0 until n) {
        val a = readLine()!!.split(' ').map { it.toInt() - 1 }
        for (j in a.indices) {
            t[i][j] = a[j]
        }
    }

    val id = Array(n) { IntArray(n) { -1 } }
    var size = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            id[i][j] = size
            id[j][i] = size
            size++
        }
    }

    val graph = Array(size) { mutableListOf<Int>() }
    for (i in 0 until n) {
        for (j in 0 until n - 2) {
            val u = id[i][t[i][j]]
            val v = id[i][t[i][j + 1]]
            graph[u].add(v)
        }
    }

    val visited = BooleanArray(size)
    val computed = BooleanArray(size)
    val dp = IntArray(size)

    fun dfs(u: Int): Int {
        if (visited[u]) {
            return if (computed[u]) dp[u] else -1
        }
        visited[u] = true
        dp[u] = 1
        for (v in graph[u]) {
            val r = dfs(v)
            if (r == -1) return -1
            dp[u] = max(dp[u], r + 1)
        }
        computed[u] = true
        return dp[u]
    }

    var ans = 0
    for (i in 0 until size) {
        val r = dfs(i)
        if (r == -1) {
            ans = -1
            break
        }
        ans = max(ans, r)
    }

    println(ans)
}

