fun main() {
    val s = readLine()!!
    val t = readLine()!!
    println(if (s == t.slice(s.indices)) "Yes" else "No")
}

