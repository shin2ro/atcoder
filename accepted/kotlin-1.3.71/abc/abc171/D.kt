fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }

    var sum = 0L
    val cnt = IntArray(100001)
    for (i in a) {
        cnt[i]++
        sum += i
    }

    val q = readLine()!!.toInt()
    (0 until q)
            .map {
                val (b, c) = readLine()!!.split(' ').map { it.toInt() }
                sum += (c - b) * cnt[b]
                cnt[c] += cnt[b]
                cnt[b] = 0
                sum
            }
            .joinToString("\n")
            .let { println(it) }
}

