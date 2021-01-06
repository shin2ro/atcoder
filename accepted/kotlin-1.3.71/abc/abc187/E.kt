import java.util.ArrayDeque

fun main() {
    val root = 1

    val n = readLine()!!.toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val edges = (0 until n - 1).map {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
        a to b
    }

    val depth = IntArray(n + 1) { -1 }

    run {
        depth[root] = 0
        val stack = ArrayDeque<Int>()
        stack.addFirst(root)

        while (stack.isNotEmpty()) {
            val u = stack.removeFirst()
            for (v in graph[u]) {
                if (depth[v] < 0) {
                    depth[v] = depth[u] + 1
                    stack.addFirst(v)
                }
            }
        }
    }

    val c = LongArray(n + 1)

    val q = readLine()!!.toInt()
    repeat(q) {
        val (t, e, x) = run {
            val (t, e, x) = readLine()!!.split(' ').map { it.toInt() }
            Triple(t, e - 1, x.toLong())
        }
        val (a, b) = if (t == 1) {
            val (a, b) = edges[e]
            a to b
        } else {
            val (a, b) = edges[e]
            b to a
        }

        if (depth[a] < depth[b]) {
            c[root] += x
            c[b] -= x
        } else {
            c[a] += x
        }
    }

    val ans = LongArray(n + 1) { -1 }

    run {
        ans[root] = c[root]
        val stack = ArrayDeque<Int>()
        stack.addFirst(root)

        while (stack.isNotEmpty()) {
            val u = stack.removeFirst()
            for (v in graph[u]) {
                if (ans[v] < 0L) {
                    ans[v] = ans[u] + c[v]
                    stack.addFirst(v)
                }
            }
        }
    }

    println(ans.slice(1..n).joinToString("\n"))
}

