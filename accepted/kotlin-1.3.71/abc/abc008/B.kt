fun main() {
    val n = readLine()!!.toInt()
    val ans = (0 until n)
            .map { readLine()!! }
            .groupingBy { it }
            .eachCount()
            .maxBy { it.value }
            .let { it?.key }
    println(ans)
}

