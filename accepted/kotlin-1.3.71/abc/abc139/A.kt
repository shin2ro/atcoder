fun main() {
    val s = readLine()!!
    val t = readLine()!!
    println((0 until 3).count { s[it] == t[it] })
}
