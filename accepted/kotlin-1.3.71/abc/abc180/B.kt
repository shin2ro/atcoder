import kotlin.math.absoluteValue
import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val xs = readLine()!!.split(' ').map { it.toLong() }
    println(xs.map { it.absoluteValue }.sum())
    println(xs.map { 1.0 * it * it }.sum().let { sqrt(it) })
    println(xs.map { it.absoluteValue }.max())
}

