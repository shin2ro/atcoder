fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!
    var ans = 0
    for (i in 0 until n) {
        ans += setOf(a[i], b[i], c[i]).size - 1
    }
    println(ans)
}
