import java.util.*

fun main(args: Array<String>) {
    val (h, w, t) = readLine()!!.split(' ').map { it.toInt() }
    val grid = (0 until h).map { readLine()!!.toCharArray() }.toTypedArray()
    val (s, g) = run {
        var s = 0 to 0
        var g = 0 to 0
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (grid[i][j] == 'S') s = i to j
                if (grid[i][j] == 'G') g = i to j
            }
        }
        s to g
    }

    val d = listOf(0, 1, 0, -1).toIntArray()
    var l = 1
    var r = t
    while (l < r) {
        val x = l + (r - l + 1) / 2
        val visited = Array(h) { LongArray(w) { -1 } }
        visited[s.first][s.second] = 0

        val queue = PriorityQueue<Pair<Int, Int>>(h * w) { o1, o2 ->
            visited[o1.first][o1.second].compareTo(visited[o2.first][o2.second])
        }
        queue.add(s)

        while (queue.isNotEmpty()) {
            val p = queue.remove()
            val c = visited[p.first][p.second]
            for (i in 0 until 4) {
                val di = p.first + d[i]
                val dj = p.second + d[i xor 1]
                if (di !in 0 until h || dj !in 0 until w) continue
                if (visited[di][dj] != -1L) continue
                visited[di][dj] = c + if (grid[di][dj] == '#') x else 1
                queue.add(di to dj)
            }
        }

        val cost = visited[g.first][g.second]

        if (cost <= t) {
            l = x
        } else {
            r = x - 1
        }

    }

    println(l)
}

