import kotlin.math.min

fun main() {
    val (a, b, c, k) = readLine()!!.split(' ').map { it.toInt() }
    val x = min(a, k)
    val y = min(b, k - x)
    val z = min(c, k - x - y)
    println(x - z)
}
