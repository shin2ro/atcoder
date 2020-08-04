import kotlin.math.abs

fun main() {
    val (x, n) = readLine()!!.split(' ').map { it.toInt() }
    val p = readLine()!!
            .let {
                if (it.isEmpty()) emptySet()
                else it.split(' ').map { s -> s.toInt() }.toSet()
            }
    var ans = 0
    for (i in 1..101) {
        if (p.contains(i)) continue
        if (abs(x - i) < abs(x - ans)) {
            ans = i
        }
    }
    println(ans)
}

