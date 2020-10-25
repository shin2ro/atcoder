fun main() {
    val (n, x, m) = readLine()!!.split(' ').map { it.toLong() }
    val a = mutableListOf<Long>()
    val map = mutableMapOf<Long, Int>()

    map[x] = a.size
    a.add(x)

    var i = 0
    while (true) {
        val ai = a.last() * a.last() % m
        if (ai == 0L) {
            i = a.size
            a.add(ai)
            break
        }
        if (map.containsKey(ai)) {
            i = map[ai]!!
            break
        }
        map[ai] = a.size
        a.add(ai)
    }

    var ans = 0L

    ans += a.slice(0 until i).sum()

    val n1 = n - i
    val n2 = a.size - i

    ans += a.slice(i until a.size).sum() * (n1 / n2)
    ans += a.slice(i until (i + (n1 % n2).toInt())).sum()

    println(ans)
}

