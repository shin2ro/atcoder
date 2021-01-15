import java.util.ArrayDeque

typealias Point = Pair<Int, Int>

fun main() {
    val d = intArrayOf(0, 1, 0, -1)
    val alphabets = ('a'..'z').toSet()

    val (H, W) = readLine()!!.split(' ').map { it.toInt() }
    val grid = (0 until H).map {
        val s = readLine()!!
        s.toCharArray()
    }.toTypedArray()

    val visited = Array(H) { BooleanArray(W) { false } }
    val queue = ArrayDeque<Pair<Point, Int>>()
    val teleports = Array(26) { mutableListOf<Point>() }

    for (i in 0 until H) {
        for (j in 0 until W) {
            if (grid[i][j] == 'S') {
                queue.addLast(Point(i, j) to 0)
                visited[i][j] = true
            }
            if (grid[i][j] in alphabets) teleports[grid[i][j] - 'a'].add(Point(i, j))
        }
    }

    var ans = -1

    while (queue.isNotEmpty()) {
        val (p, t) = queue.removeFirst()
        val c = grid[p.first][p.second]

        if (c == 'G') {
            ans = t
            break
        }

        for (i in 0 until 4) {
            val di = p.first + d[i]
            val dj = p.second + d[i xor 1]
            if (di !in 0 until H || dj !in 0 until W) continue
            if (grid[di][dj] == '#') continue
            if (!visited[di][dj]) {
                queue.addLast(Point(di, dj) to t + 1)
                visited[di][dj] = true
            }
        }

        if (c in alphabets) {
            for ((i, j) in teleports[c - 'a']) {
                if (!visited[i][j]) {
                    queue.addLast(Point(i, j) to t + 1)
                    visited[i][j] = true
                }
            }
            teleports[c - 'a'].clear()
        }
    }

    println(ans)
}

