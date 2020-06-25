fun main() {

    fun f(n: Long): Long {
        var y = 0L
        var x = n
        var i = 1L
        while (x > 0) {
            y += (x % 10) * i
            x /= 10
            i *= n
        }
        return y
    }

    val a = readLine()!!.toLong()

    var ans = -1
    for (i in 10..10000) {
        if (f(i + 0L) == a) {
            ans = i
            break
        }
    }

    println(ans)
}
