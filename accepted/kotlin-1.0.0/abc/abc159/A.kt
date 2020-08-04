fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    println(n * (n - 1) / 2 + m * (m - 1) / 2)
}

