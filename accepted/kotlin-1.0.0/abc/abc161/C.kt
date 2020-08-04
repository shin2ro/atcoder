fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map { it.toLong() }
    println(Math.min(n % k, Math.abs((n % k) - k)))
}

