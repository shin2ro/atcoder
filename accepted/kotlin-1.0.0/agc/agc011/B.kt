fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toLong() }.sorted()
    val s = LongArray(n + 1)
    for (i in 0 until n) {
        s[i + 1] = s[i] + a[i]
    }

    var min = 0
    for (i in 1 until n) {
        if (s[i] * 2 >= a[i]) continue
        min = i
    }

    println(n - min)
}

