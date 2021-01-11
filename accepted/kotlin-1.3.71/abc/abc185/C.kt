import java.math.BigInteger

fun main() {
    val l = readLine()!!.toInt()
    val n = l - 1L
    val k = 11L
    val f = { acc: BigInteger, x: Long -> acc * BigInteger.valueOf(x) }
    val ans = (n downTo n - k + 1).fold(BigInteger.ONE, f) / (k downTo 1).fold(BigInteger.ONE, f)
    println(ans)
}

