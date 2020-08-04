fun main() {
    val (s, l, r) = readLine()!!.split(' ').map { it.toInt() }
    println(s.coerceIn(l..r))
}

