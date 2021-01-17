fun main() {
    val (n, r) = readLine()!!.split(' ').map { it.toInt() }
    val s = readLine()!!

    var ans = 0
    var ri = 0
    for (i in n - 1 downTo 0) {
        if (s[i] == '.') {
            ri = (i - r + 1).coerceAtLeast(0)
            ans += ri + 1
            break
        }
    }

    var i = ri - 1
    while (i >= 0) {
        if (s[i] == '.') {
            ans++
            i -= r
        } else {
            i--
        }
    }

    println(ans)
}

