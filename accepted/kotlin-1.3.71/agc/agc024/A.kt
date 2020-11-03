fun main() {
    val (a, b, c, k) = readLine()!!.split(' ').map { it.toLong() }
    println(if (k % 2 == 0L) a - b else b - a)
}

