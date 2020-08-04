fun main() {
    var n = readLine()!!.toLong()
    var ans = ""
    while (true) {
        n--
        ans += ('a' + (n % 26).toInt())
        n /= 26
        if (n == 0L) break
    }
    println(ans.reversed())
}

