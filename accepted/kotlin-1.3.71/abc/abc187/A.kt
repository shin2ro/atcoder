import kotlin.math.max

fun main() {
    fun s(n: Int): Int {
        var n = n
        var r = 0
        while (n > 0) {
            r += n % 10
            n /= 10
        }
        return r
    }
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(max(s(a), s(b)))
}

