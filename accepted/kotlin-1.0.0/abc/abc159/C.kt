fun main(args: Array<String>) {
    val l = readLine()!!.toDouble()
    val ans = (l / 3.0).let { it * it * it }
    println(ans)
}

