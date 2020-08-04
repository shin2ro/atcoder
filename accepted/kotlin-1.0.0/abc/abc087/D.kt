import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val g = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    repeat(m) {
        val (l, r, d) = readLine()!!.split(' ').map { it.toInt() }
        g.getOrPut(l) { mutableListOf() }.add(r to d)
        g.getOrPut(r) { mutableListOf() }.add(l to -d)
    }

    val visited = mutableMapOf<Int, Int>()
    var ans = true

    for (root in g.keys) {
        if (visited.containsKey(root)) continue

        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(root to 0)
        visited[root] = 0
        
        while (stack.isNotEmpty()) {
            val (u, x) = stack.removeLast()
            for ((v, d) in g[u]!!) {
                if (visited.containsKey(v)) {
                    if (visited[v] != x + d) {
                        ans = false
                        break
                    }
                } else {
                    stack.addLast(v to x + d)
                    visited[v] = x + d
                }
            }
        }

        if (!ans) break
    }

    println(if (ans) "Yes" else "No")
}

