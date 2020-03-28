fun main(args: Array<String>) {
    val (k, n) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }
    var mx = 0
    for (i in 1 until n) {
        mx = Math.max(a[i] - a[i - 1], mx)
    }
    mx = Math.max(a.first() + k - a.last(), mx)
    println(k - mx)
}
