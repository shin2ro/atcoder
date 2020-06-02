fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = n / 60 / 60
    val m = n / 60 % 60
    val s = n % 60
    val ans = listOf(h, m, s).joinToString(":") { it.toString().padStart(2, '0') }
    println(ans)
}
