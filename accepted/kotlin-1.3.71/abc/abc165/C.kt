import kotlin.math.max

fun main() {
    val (n, m, q) = readLine()!!.split(' ').map { it.toInt() }
    val qs = (0 until q).map { readLine()!!.split(' ').map { it.toInt() } }

    fun f(list: List<Int>): Int {
        if (list.size == n) {
            val l = list.reversed()
            var score = 0
            for ((a, b, c, d) in qs) {
                if (l[b - 1] - l[a - 1] == c) score += d
            }
            return score
        }
        var ans = 0
        val x = if (list.isEmpty()) m else list.last()
        for (i in 1..x) {
            ans = max(ans, f(list + listOf(i)))
        }
        return ans
    }

    println(f(emptyList()))
}
