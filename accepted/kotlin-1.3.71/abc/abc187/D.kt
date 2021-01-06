fun main() {
    val n = readLine()!!.toInt()
    val votes = (0 until n).map {
        val (a, b) = readLine()!!.split(' ').map { it.toLong() }
        a to b
    }.sortedByDescending { it.first * 2 + it.second }

    var s1 = votes.map { it.first }.sum()
    var s2 = 0L
    var i = 0
    while (s2 <= s1) {
        val (a, b) = votes[i++]
        s1 -= a
        s2 += a + b
    }
    println(i)
}

