fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(a + if (b >= a) 0 else -1)
}

