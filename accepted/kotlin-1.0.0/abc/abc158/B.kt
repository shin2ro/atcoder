fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map { it.toLong() }
    println((n / (a + b) * a) + Math.min(n % (a + b), a))
}
