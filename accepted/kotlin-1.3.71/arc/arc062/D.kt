fun main() {
    val s = readLine()!!
    println(s.length / 2 - s.count { it == 'p' })
}
