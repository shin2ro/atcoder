fun main() {
    val xs = readLine()!!.split(' ').map { it.toInt() }
    val k = readLine()!!.toInt()
    val m = xs.max()!!
    println(xs.sum() - m + m * (1 shl k))
}

