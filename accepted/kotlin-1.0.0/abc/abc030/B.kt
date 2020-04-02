fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    println(Math.abs(((n % 12) * 30 + m * 0.5) - (m * 6)).let { if (it > 180) 360 - it else it })
}
