import kotlin.math.abs

fun main() {
    val (r1, c1) = readLine()!!.split(' ').map { it.toInt() }
    val (r2, c2) = readLine()!!.split(' ').map { it.toInt() }
    val r = r2 - r1
    val c = c2 - c1

    val ans = when {
        r to c == 0 to 0 -> 0
        r == c -> 1
        r == -c -> 1
        abs(r) + abs(c) <= 3 -> 1
        (r1 + c1 + r2 + c2) % 2 == 0 -> 2
        abs(r) + abs(c) <= 6 -> 2
        abs(r + c) <= 3 -> 2
        abs(r - c) <= 3 -> 2
        else -> 3
    }

    println(ans)
}

