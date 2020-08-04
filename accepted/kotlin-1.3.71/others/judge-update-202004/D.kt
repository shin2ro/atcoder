import java.io.PrintWriter

fun main() {
    val pw = PrintWriter(System.out)

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    val (n, q) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val s = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    val b = IntArray(n)
    b[0] = a[0]
    for (i in 1 until n) {
        b[i] = gcd(b[i - 1], a[i])
    }

    for (i in 0 until q) {
        var l = 0
        var r = n - 1
        while (l < r) {
            val m = l + (r - l) / 2
            val x = gcd(s[i], b[m])
            if (x == 1) {
                r = m
            } else {
                l = m + 1
            }
        }

        pw.println(gcd(s[i], b[l]).let { if (it == 1) l + 1 else it })
    }

    pw.flush()
}

