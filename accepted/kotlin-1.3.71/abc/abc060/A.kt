fun main() {
    val (a, b, c) = readLine()!!.split(' ')
    println(if (a.last() == b.first() && b.last() == c.first()) "YES" else "NO")
}
