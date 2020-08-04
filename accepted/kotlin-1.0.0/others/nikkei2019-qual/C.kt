fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs = (0 until n)
            .map {
                val (a, b) = readLine()!!.split(' ').map { it.toLong() }
                a to b
            }
            .sortedByDescending { it.first + it.second }
    val ans = xs.mapIndexed { index, pair -> if (index % 2 == 0) pair.first else -pair.second }.sum()
    println(ans)
}

