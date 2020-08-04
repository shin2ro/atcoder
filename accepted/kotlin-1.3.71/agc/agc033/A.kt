import java.util.ArrayDeque

fun main() {
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val grid = (0 until h).map { readLine()!! }
    val visited = Array(h) { IntArray(w) { -1 } }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val d = intArrayOf(1, 0, -1, 0)

    for (i in 0 until h) {
        for (j in 0 until w) {
            if (grid[i][j] == '#') {
                queue.addLast(i to j)
                visited[i][j] = 0
            }
        }
    }

    var ans = 0

    while (queue.isNotEmpty()) {
        val (i, j) = queue.removeFirst()
        for (k in 0 until 4) {
            val di = i + d[k]
            val dj = j + d[k xor 1]

            if (di !in 0 until h) continue
            if (dj !in 0 until w) continue
            if (visited[di][dj] >= 0) continue

            queue.addLast(di to dj)
            visited[di][dj] = visited[i][j] + 1
            ans = ans.coerceAtLeast(visited[di][dj])
        }
    }

    println(ans)
}

