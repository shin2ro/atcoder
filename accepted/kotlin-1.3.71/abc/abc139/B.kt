fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println((b - 1 + a - 2) / (a - 1))
}

