fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map { it.toInt() }
    println("${Math.min(a, b)} ${Math.max(a + b - n, 0)}")
}

