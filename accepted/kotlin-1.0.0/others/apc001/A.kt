fun main(args: Array<String>) {
    val (x, y) = readLine()!!.split(' ').map { it.toLong() }
    println(if (x % y == 0L) -1 else x)
}
