fun main(args: Array<String>) {
    val x = readLine()!!.toInt()
    println((x / 500 * 1000) + (x % 500 / 5 * 5))
}
