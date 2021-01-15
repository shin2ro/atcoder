fun main() {
    val (n, x) = readLine()!!.split(' ').map { it.toInt() }
    val s = readLine()!!
    var ans = x
    for (c in s) {
        if (c == 'o') {
            ++ans
        } else {
            ans = (--ans).coerceAtLeast(0)
        }
    }
    println(ans)
}

