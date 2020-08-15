fun main() {
    val n = readLine()!!.toInt()
    println(if ((2..n).count { n % it == 0 } == 1) "YES" else "NO")
}

