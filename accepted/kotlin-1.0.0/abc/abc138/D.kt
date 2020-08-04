import java.util.*

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map { it.toInt() }

    val g = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        g[a].add(b)
        g[b].add(a)
    }

    val cnt = IntArray(n + 1)
    repeat(q) {
        val (p, x) = readLine()!!.split(' ').map { it.toInt() }
        cnt[p] += x
    }

    val visited = BooleanArray(n + 1) { false }
    val stack = ArrayDeque<Int>()
    stack.addLast(1)

    while (stack.isNotEmpty()) {
        val v = stack.removeLast()
        visited[v] = true

        for (u in g[v]) {
            if (visited[u]) continue
            cnt[u] = cnt[v] + cnt[u]
            stack.addLast(u)
        }
    }

    println(cnt.slice(1..n).joinToString(" "))
}

