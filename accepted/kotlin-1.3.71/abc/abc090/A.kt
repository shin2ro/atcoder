fun main() {
    (0 until 3)
            .map { readLine()!![it] }
            .joinToString("")
            .let { println(it) }
}
