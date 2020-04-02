fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val (x, y) = readLine()!!.split(' ').map { it.toLong() }
    val a = readLine()!!.split(' ').map { it.toLong() }
    val b = readLine()!!.split(' ').map { it.toLong() }

    var ans = 0
    var cur = 0L
    var i = 0
    var j = 0
    var s = 0

    loop@ while (i < n || j < m) {

        when (s) {
            0 -> {
                if (i == n) break@loop

                if (cur <= a[i]) {
                    cur = a[i] + x
                    s = 1
                }
                i++
            }
            1 -> {
                if (j == m) break@loop

                if (cur <= b[j]) {
                    cur = b[j] + y
                    ans++
                    s = 0
                }
                j++
            }
        }

    }

    println(ans)
}
