fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val v = readLine()!!.split(' ').map { it.toDouble() }
    println(v.sorted().reduce { acc, d -> (acc + d) / 2.0 })
}

