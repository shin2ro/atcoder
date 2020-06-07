fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.split(' ')
    println(if (s.toSet().size == 3) "Three" else "Four")
}
