fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val grid = (0 until h).map { readLine()!!.toCharArray() }.toTypedArray()
    val dx = listOf(0, 1, 1, 1, 0, -1, -1, -1)
    val dy = listOf(-1, -1, 0, 1, 1, 1, 0, -1)
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (grid[i][j] == '.') {
                var cnt = 0
                for (k in 0 until 8) {
                    val x = j + dx[k]
                    val y = i + dy[k]
                    if (x in 0 until w && y in 0 until h) {
                        if (grid[y][x] == '#') cnt++
                    }
                }
                grid[i][j] = '0' + cnt
            }
        }
    }
    println(grid.joinToString("\n") { String(it) })
}

