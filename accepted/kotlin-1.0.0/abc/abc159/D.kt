fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }

    val cnt = mutableMapOf<Int, Long>()
    for (i in a) {
        cnt[i] = (cnt[i] ?: 0) + 1
    }
    val s = cnt.map { entry -> entry.value * (entry.value - 1) / 2 }.sum()

    (0 until n)
            .map { s - cnt[a[it]]!! + 1 }
            .joinToString("\n")
            .let { println(it) }
}

