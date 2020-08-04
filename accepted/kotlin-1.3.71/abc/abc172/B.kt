fun main() {
    val s = readLine()!!
    val t = readLine()!!
    val ans = s.indices.count { s[it] != t[it] }
    println(ans)
}

