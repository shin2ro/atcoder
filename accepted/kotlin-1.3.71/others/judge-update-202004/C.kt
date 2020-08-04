fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    fun f(x: Int, y: Int, z: Int): Int {
        if (x > a || y > b || z > c) return 0
        if (x < y) return 0
        if (y < z) return 0
        if (x + y + z == a + b + z) return 1
        return f(x + 1, y, z) + f(x, y + 1, z) + f(x, y, z + 1)
    }
    println(f(0, 0, 0))
}

