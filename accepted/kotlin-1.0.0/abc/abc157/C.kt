fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val xs = BooleanArray(Math.pow(10.0, n.toDouble()).toInt()) { true }
    for (i in xs.indices) {
        if (i.toString().length != n) xs[i] = false
    }
    repeat(m) {
        val (s, c) = readLine()!!.split(' ').map { it.toInt() }
        for (i in xs.indices.filter { xs[it] }) {
            if (i.toString()[s - 1] - '0' != c) xs[i] = false
        }
    }
    var ans = -1
    for (i in xs.indices) {
        if (xs[i]) {
            ans = i
            break
        }
    }
    println(ans)
}

