fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }

    val lm = mutableMapOf<Int, Long>()
    val rm = mutableMapOf<Int, Long>()

    for (i in a.indices) {
        val l = i + a[i]
        lm[l] = (lm[l] ?: 0) + 1
        val r = i - a[i]
        rm[r] = (rm[r] ?: 0) + 1
    }

    var ans = 0L
    for (l in lm.keys) {
        if (rm.containsKey(l)) ans += lm[l]!! * rm[l]!!
    }
    println(ans)
}
