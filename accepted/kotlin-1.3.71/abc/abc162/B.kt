fun main() {
    val n = readLine()!!.toInt()
    (1..n).filter { !(it % 3 == 0 || it % 5 == 0) }
            .map { it.toLong() }
            .sum()
            .let { println(it) }
}
