import java.util.*

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map { it.toInt() }

    val g = mutableMapOf<Int, MutableList<Int>>()
    repeat(n - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        g.getOrPut(a) { mutableListOf() }.add(b)
        g.getOrPut(b) { mutableListOf() }.add(a)
    }

    val cnt = IntArray(n + 1)
    repeat(q) {
        val (p, x) = readLine()!!.split(' ').map { it.toInt() }
        cnt[p] += x
    }

    val visited = BooleanArray(n + 1) { false }
    val stack = ArrayDeque<Int>()
    stack.addLast(1)
    visited[1] = true

    while (stack.isNotEmpty()) {
        val v = stack.removeLast()
        for (u in g[v]!!) {
            if (visited[u]) continue
            cnt[u] = cnt[v] + cnt[u]
            stack.addLast(u)
            visited[u] = true
        }
    }

    println(cnt.slice(1..n).joinToString(" "))
}
