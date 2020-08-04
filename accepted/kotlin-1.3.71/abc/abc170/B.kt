fun main() {
    val (x, y) = readLine()!!.split(' ').map { it.toInt() }
    val ans = (0..x).any {
        it * 2 + (x - it) * 4 == y
    }
    println(if (ans) "Yes" else "No")
}

