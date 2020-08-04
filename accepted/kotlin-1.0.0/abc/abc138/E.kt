fun <T> List<T>.upperBound(element: T): Int where T : Comparable<T> {
    return this
        .binarySearch { if (it > element) 1 else -1 }
        .let { -(it + 1) }
}

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!

    val table = Array(26) { mutableListOf<Int>() }
    for ((i, c) in s.repeat(2).withIndex()) {
        table[c - 'a'].add(i + 1)
    }

    var cur = 0L
    for (c in t) {
        val i = c - 'a'
        if (table[i].isEmpty()) {
            cur = -1
            break
        }

        val p1 = (cur % s.length).toInt()
        val p2 = table[i].upperBound(p1)
        cur += table[i][p2] - p1
    }
    println(cur)
}

