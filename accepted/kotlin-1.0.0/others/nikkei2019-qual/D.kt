import java.util.*

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val g = Array(n + 1) { mutableListOf<Int>() }
    val degree = IntArray(n + 1)

    repeat(n - 1 + m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        g[a].add(b)
        degree[b]++
    }

    val sorted = mutableListOf<Int>()
    val queue = ArrayDeque<Int>()
    for (v in 1..n) {
        if (degree[v] == 0) {
            queue.addLast(v)
        }
    }

    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        for (u in g[v]) {
            degree[u]--
            if (degree[u] == 0) queue.addLast(u)
        }
        sorted.add(v)
    }

    val rev = IntArray(n + 1)
    for ((i, v) in sorted.withIndex()) {
        rev[v] = i
    }

    val ans = IntArray(n + 1) { sorted[0] }
    ans[sorted[0]] = 0
    for ((a, bs) in g.withIndex()) {
        for (b in bs) {
            if (rev[ans[b]] < rev[a]) ans[b] = a
        }
    }

    println(ans.slice(1..n).joinToString("\n"))
}

