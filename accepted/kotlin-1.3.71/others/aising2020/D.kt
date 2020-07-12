fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    val x = s.toBigInteger(2)
    val bc = x.bitCount()
    val x1 = (x % (bc + 1).toBigInteger()).toInt()
    val x2 = if (bc > 1) (x % (bc - 1).toBigInteger()).toInt() else 0

    val ans = IntArray(n)
    var b1 = 1
    var b2 = 1

    for (i in (0 until n)) {
        b1 = if (i == 0) b1 else b1 * 2
        b1 %= bc + 1

        if (bc > 1) {
            b2 = if (i == 0) b2 else b2 * 2
            b2 %= bc - 1
        }

        val idx = n - i - 1
        if (s[idx] == '1' && bc <= 1) {
            ans[idx] = 0
            continue
        }

        var cnt = 1
        var xi = if (s[idx] == '1') {
            (x2 + (bc - 1) - b2) % (bc - 1)
        } else {
            (x1 + b1) % (bc + 1)
        }.toInt()

        while (xi > 0) {
            cnt++
            xi %= Integer.bitCount(xi)
        }

        ans[idx] = cnt
    }

    println(ans.joinToString("\n"))
}
