fun main(args: Array<String>) {
    val s = readLine()!!
    val n = s.length

    fun f(s: String): Boolean {
        return s == s.reversed()
    }

    println(if (f(s) && f(s.slice(0 until n / 2)) && f(s.slice(n / 2 + 1 until n))) "Yes" else "No")
}
