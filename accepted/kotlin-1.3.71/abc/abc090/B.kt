fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val ans = (a..b).count { it == it.toString().reversed().toInt() }
    println(ans)
}

