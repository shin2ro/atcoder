fun main(args: Array<String>) {
    val t = LongArray(100001)
    var cur = 0

    fun rec(s: String, f: Boolean) {
        if (cur == t.size) {
            return
        }

        if (s.length == 10) {
            t[cur] = s.toLong()
            cur++
            return
        }

        if (f) {
            rec(s + '0', true)
            for (i in 1..9) {
                rec(s + ('0' + i), false)
            }
        } else {
            val x = s.last() - '0'

            for (i in -1..1) {
                if (x + i in 0..9) {
                    rec(s + ('0' + x + i), false)
                }
            }
        }
    }

    rec("", true)

    println(t[readLine()!!.toInt()])
}
