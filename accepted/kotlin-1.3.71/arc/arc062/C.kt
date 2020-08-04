import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    var t = 1L
    var a = 1L
    repeat(n) {
        val (ti, ai) = readLine()!!.split(' ').map { it.toInt() }
        val i = max((t + ti - 1) / ti, (a + ai - 1) / ai)
        t = ti * i
        a = ai * i
    }
    println(t + a)
}

