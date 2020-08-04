fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    val cnt = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        cnt[a[i]] = (cnt[a[i]] ?: 0) + 1
    }
    val ans = cnt.map { if (it.value - it.key >= 0)  it.value - it.key else it.value }.sum()
    println(ans)
}

