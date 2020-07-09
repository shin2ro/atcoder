import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val hs = readLine()!!.split(' ').map { it.toInt() }
    var ans = 0
    var cnt = 0
    for (i in 0 until n - 1) {
        if (hs[i] >= hs[i + 1]) {
            cnt++
        } else {
            ans = max(cnt, ans)
            cnt = 0
        }
    }
    ans = max(cnt, ans)
    println(ans)
}
