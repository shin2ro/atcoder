import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val points = (0 until n).map {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }
        x to y
    }

    var ans = 0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val (x1, y1) = points[i]
            val (x2, y2) = points[j]
            if (abs(x2 - x1) >= abs(y2 - y1)) ans++
        }
    }

    println(ans)
}

