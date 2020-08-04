fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val cnt = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        cnt[a]++
        cnt[b]++
    }
    println(if (cnt.all { it % 2 == 0 }) "YES" else "NO")
}

