fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(b * Math.min(n, 5) + a * Math.max(n - 5, 0))
}
