fun main() {
    val grid = Array(50) { CharArray(100) { '#' } } + Array(50) { CharArray(100) { '.' } }
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }

    for (i in 0 until a - 1) {
        grid[(i / 50) * 2][i % 50 * 2] = '.'
    }

    for (i in 0 until b - 1) {
        grid[(i / 50) * 2 + 51][i % 50 * 2] = '#'
    }

    println("100 100")
    println(grid.joinToString("\n") { it.joinToString("") })
}

