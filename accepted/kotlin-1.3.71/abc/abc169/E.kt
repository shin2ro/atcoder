fun main() {
    val n = readLine()!!.toInt()
    val xs = (0 until n).map {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        a to b
    }

    val ans = if (n % 2 == 0) {
        val l = xs.map { it.first }.sorted().let { it[n / 2 - 1] + it[n / 2] }
        val r = xs.map { it.second }.sorted().let { it[n / 2 - 1] + it[n / 2] }
        r - l + 1
    } else {
        val l = xs.map { it.first }.sorted()[n / 2]
        val r = xs.map { it.second }.sorted()[n / 2]
        r - l + 1
    }

    println(ans)
}

