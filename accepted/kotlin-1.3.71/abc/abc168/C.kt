import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val (a, b, h, m) = readLine()!!.split(' ').map { it.toDouble() }
    val d1 = 30 * h + 0.5 * m
    val d2 = 6 * m
    val d = if (d1 > d2) d1 - d2 else d2 - d1
    val r = d * Math.PI / 180
    val c = a.pow(2) + b.pow(2) - Math.cos(r) * 2 * a * b
    println(sqrt(c))
}
