fun main() {
    var (a, b, c, d) = readLine()!!.split(' ').map { it.toInt() }
    while (a > 0 && b > 0) {
        a -= d
        c -= b
    }
    println(if (c > 0) "No" else "Yes")
}

