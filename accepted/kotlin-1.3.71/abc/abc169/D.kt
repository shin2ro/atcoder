fun main() {
    val n = readLine()!!.toLong()

    fun f(n: Long): MutableMap<Long, Long> {
        var x = n
        val fs = mutableMapOf<Long, Long>()
        var i = 2L
        while (i * i <= x) {
            if (x % i == 0L) {
                fs[i] = (fs[i] ?: 0) + 1
                x /= i
                continue
            }
            i++
        }
        if (x > 1) fs[x] = (fs[x] ?: 0) + 1
        return fs
    }

    val fs = f(n)

    var ans = 0
    var i = 1L
    while (true) {
        var flag = true

        for ((x, cnt) in fs) {
            if (cnt >= i) {
                ans++
                fs[x] = cnt - i
                flag = false
            }
        }

        i++
        if (flag) break
    }

    println(ans)
}
