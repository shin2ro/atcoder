fun main() {
    val (n, k) = readLine()!!.split(' ').let { it[0].toInt() to it[1].toLong() }
    val a = readLine()!!.split(' ').map { it.toInt() - 1 }
    val b = IntArray(n) { -1 }
    b[0] = 0

    var cur = 0
    var flag = false
    var x = k

    while (x > 0) {
        x--
        val next = a[cur]

        if (flag) {
            cur = next
            continue
        }

        if (b[next] == -1) {
            b[next] = b[cur] + 1
            cur = next
            continue
        }

        flag = true
        x %= (b[cur] + 1 - b[next])
        cur = next
    }

    println(cur + 1)
}
