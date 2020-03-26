fun main(args: Array<String>) {
    val s = readLine()!!
    val cs = CharArray(200000) + s.toCharArray() + CharArray(200000)

    var l = 200000
    var r = l + s.length
    var d = 0

    val n = readLine()!!.toInt()
    repeat(n) {
        val q = readLine()!!
        if (q[0] == '1') {
            d += 1
            d %= 2
            return@repeat
        }

        val f = (q[2] - '1' + d) % 2
        if (f == 0) {
            cs[l - 1] = q[4]
            l--
        } else {
            cs[r] = q[4]
            r++
        }
    }

    println(cs.slice(l until r).let { if (d == 0) it else it.reversed() }.joinToString(""))
}
