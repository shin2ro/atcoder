import java.util.ArrayDeque

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Int>>()

    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        graph[a] = graph[a] ?: mutableListOf()
        graph[b] = graph[b] ?: mutableListOf()
        graph[a]!!.add(b)
        graph[b]!!.add(a)
    }

    val visited = IntArray(n + 1) { -1 }
    val queue = ArrayDeque<Int>()

    queue.addLast(1)
    visited[1] = 0

    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        for (u in graph[v]!!) {
            if (visited[u] == -1) {
                queue.addLast(u)
                visited[u] = v
            }
        }
    }

    if (visited.slice(2..n).count { it == -1 } > 0) {
        println("No")
    } else {
        println("Yes")
        println(visited.slice(2..n).joinToString("\n"))
    }

}

