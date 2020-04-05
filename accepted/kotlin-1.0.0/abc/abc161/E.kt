import java.io.PrintWriter

fun main(args: Array<String>) {
    val (n, k, c) = readLine()!!.split(' ').map { it.toInt() }
    val s = readLine()!!

    fun f(s: String): IntArray {
        val list = mutableListOf<Int>()
        var i = 0
        while (i < n && list.size < k) {
            if (s[i] == 'o') {
                list.add(i)
                i += c + 1
            } else {
                i++
            }
        }
        return list.toIntArray()
    }

    val l = f(s)
    val r = f(s.reversed())
    for (i in r.indices) r[i] = n - r[i] - 1

    val lastL = IntArray(n + 1) { -1 }
    for (i in 0 until k) lastL[l[i] + 1] = i
    for (i in 0 until n) if (lastL[i + 1] == -1) lastL[i + 1] = lastL[i]

    val lastR = IntArray(n + 1) { -1 }
    for (i in 0 until k) lastR[r[i]] = i
    for (i in n - 1 downTo 0) if (lastR[i] == -1) lastR[i] = lastR[i + 1]

    val pw = PrintWriter(System.out)

    for (i in 0 until n) {
        if (s[i] == 'x') continue

        val li = lastL[i]
        val ri = lastR[i + 1]

        var cnt = 0
        cnt += li + 1
        cnt += ri + 1
        if (li != -1 && ri != -1 && r[ri] - l[li] <= c) cnt--

        if (cnt == k - 1) pw.println(i + 1)
    }

    pw.flush()
}
