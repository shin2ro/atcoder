fun solve(k: Int): Int {
    if (k % 2 == 0 || k % 5 == 0) {
        return -1
    }

    val d = IntArray(10)
    for (i in 1..10) {
        d[k * i % 10] = k * i
    }

    var cnt = 0
    var x = k
    while (x > 0) {
        if (x % 10 == 7) {
            cnt++
            x /= 10
            continue
        }

        x += d[(17 - x % 10) % 10]
    }
    return cnt
}

fun main() {
    val k = readLine()!!.toInt()
    println(solve(k))
}

