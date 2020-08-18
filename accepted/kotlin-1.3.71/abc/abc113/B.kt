import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val (t, a) = readLine()!!.split(' ').map { it.toInt() * 1000 }
    val hs = readLine()!!.split(' ').map { it.toInt() }
    val ans = hs
            .mapIndexed { i, h -> i + 1 to abs((t - h * 6) - a) }
            .minBy { it.second }!!
            .first
    println(ans)
}

