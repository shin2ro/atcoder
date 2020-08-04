fun main() {
    val (s, w) = readLine()!!.split(' ').map { it.toInt() }
    println(if (w >= s) "unsafe" else "safe")
}

