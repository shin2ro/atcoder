fun main() {
    val k = readLine()!!.toInt()
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(if ((a..b).any { it % k == 0 }) "OK" else "NG")
}

