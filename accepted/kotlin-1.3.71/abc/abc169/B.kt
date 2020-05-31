import java.math.BigInteger

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toLong() }.sorted()

    var ans = BigInteger.valueOf(1L)
    for (i in 0 until n) {
        ans *= BigInteger.valueOf(a[i])
        if (ans > BigInteger.valueOf(1e18.toLong())) {
            ans = BigInteger.valueOf(-1)
            break
        }
    }
    println(ans)
}
