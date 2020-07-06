fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val roads = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        roads[a]++
        roads[b]++
    }
    println(roads.slice(1..n).joinToString("\n"))
}
