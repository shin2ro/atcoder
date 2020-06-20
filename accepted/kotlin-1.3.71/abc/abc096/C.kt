fun main() {
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val grid = (0 until h).map { readLine()!! }
    
    val d = listOf(0, 1, 0, -1)
    var ans = true
    
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (grid[i][j] == '.') continue
            
            var drawable = false
            for (k in 0 until 4) {
                val di = i + d[k]
                val dj = j + d[k xor 1]
                if (di in 0 until h && dj in 0 until w) {
                    if (grid[di][dj] == '#') drawable = true
                }
            }
            if (!drawable) ans = false
        }
    }
    
    println(if (ans) "Yes" else "No")
}
