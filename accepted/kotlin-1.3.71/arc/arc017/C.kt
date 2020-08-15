fun <T> List<T>.lowerBound(element: T): Int where T : Comparable<T> {
    return this
        .binarySearch { if (it >= element) 1 else -1 }
        .let { -(it + 1) }
}

fun <T> List<T>.upperBound(element: T): Int where T : Comparable<T> {
    return this
        .binarySearch { if (it > element) 1 else -1 }
        .let { -(it + 1) }
}

fun main() {
    val (N, X) = readLine()!!.split(' ').map { it.toInt() }
    val items = (0 until N).map { readLine()!!.toInt() }

    val n = N / 2
    val ws = run {
        val ws = IntArray(1 shl n)
        for (i in 0 until (1 shl n)) {
            var s = 0
            for (j in 0 until n) {
                if (i shr j and 1 == 1) {
                    s += items[j]
                }
            }
            ws[i] = s
        }
        ws.sorted()
    }

    var ans = 0
    for (i in 0 until (1 shl N - n)) {
        var s = 0
        for (j in 0 until N - n) {
            if (i shr j and 1 == 1) {
                s += items[n + j]
            }
        }

        if (s <= X) {
            ans += ws.upperBound(X - s) - ws.lowerBound(X - s)
        }
    }

    println(ans)
}

