fun main() {
    val (a, b, n) = readLine()!!.split(' ').map { it.toLong() }
    println(a * (b - 1).coerceAtMost(n) / b)
}
