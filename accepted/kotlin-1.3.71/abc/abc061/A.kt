fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    println(if (c in a..b) "Yes" else "No")
}
