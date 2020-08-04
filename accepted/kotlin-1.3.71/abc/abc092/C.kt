import java.io.PrintWriter
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = IntArray(n + 2)
    for (i in 0 until n) {
        b[i + 1] = a[i]
    }
    var s = 0
    for (i in 0..n) {
        s += abs(b[i] - b[i + 1])
    }
    val pw = PrintWriter(System.out)
    for (i in 1..n) {
        pw.println(s - abs(b[i - 1] - b[i]) - abs(b[i] - b[i + 1]) + abs(b[i - 1] - b[i + 1]))
    }
    pw.flush()
}

