fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toDouble() }
    println(1.0 / a.fold(0.0) { acc, d -> acc + 1.0 / d })
}

