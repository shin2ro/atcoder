fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }
    println(maxOf(n - a.sum(), -1))
}
