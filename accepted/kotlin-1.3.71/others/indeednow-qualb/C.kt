import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val tree = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    val ans = IntArray(n)
    val visited = BooleanArray(n + 1) { false }
    val pq = PriorityQueue<Int>()
    pq.add(1)

    var cur = 0

    while (pq.isNotEmpty()) {
        val u = pq.remove()
        visited[u] = true
        ans[cur++] = u

        for (v in tree[u]) {
            if (visited[v]) continue
            pq.add(v)
        }
    }

    println(ans.joinToString(" "))
}

