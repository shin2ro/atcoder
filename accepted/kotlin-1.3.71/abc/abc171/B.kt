fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val p = readLine()!!.split(' ').map { it.toInt() }
    println(p.sorted().take(k).sum())
}
