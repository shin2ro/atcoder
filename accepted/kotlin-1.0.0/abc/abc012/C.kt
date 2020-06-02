fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val y = 2025 - n
    (1..9).flatMap { i -> (1..9).filter { j -> i * j == y }.map { j -> "$i x $j" } }
            .joinToString("\n")
            .let { println(it) }
}
