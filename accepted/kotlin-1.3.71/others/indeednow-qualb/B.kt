fun main() {
    val s = readLine()!!
    val t = readLine()!!

    var ans = -1

    val n = s.length
    for (i in s.indices) {
        if (s.slice(n - i until n) + s.slice(0 until n - i) == t) {
            ans = i
            break
        }
    }

    println(ans)
}

