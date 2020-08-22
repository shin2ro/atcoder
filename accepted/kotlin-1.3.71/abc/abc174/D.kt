import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val rc = s.count { it == 'R' }
    val ans = min(
            s.slice(0 until rc).count { it == 'W' },
            s.slice(rc until n).count { it == 'R' }
    )
    println(ans)
}

