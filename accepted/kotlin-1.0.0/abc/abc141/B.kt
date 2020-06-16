fun main(args: Array<String>) {
    val s = readLine()!!
    s.withIndex()
            .all { if (it.index % 2 == 0) it.value != 'L' else it.value != 'R' }
            .let { println(if (it) "Yes" else "No") }
}
