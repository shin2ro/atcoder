fun main() {
    val s = readLine()!!
    val w = readLine()!!.toInt()
    val ans = (s.indices step w).map { s[it] }.toCharArray()
    println(ans)
}

