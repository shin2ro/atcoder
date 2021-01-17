fun <T> List<T>.lowerBound(element: T): Int where T : Comparable<T> {
    return this
        .binarySearch { if (it >= element) 1 else -1 }
        .let { -(it + 1) }
}

fun main() {
    val n = readLine()!!.toInt()
    val t = Array(n) { mutableListOf<Int>() }
    repeat(n) {
        val s = readLine()!!
        for (i in s.indices) {
            if (s[i] == '.') t[it].add(i)
        }
    }
    var ans = 0
    for (i in 0 until n - 1) {
        if (t[i].isEmpty()) continue
        ans++
        val j = t[i + 1].lowerBound(t[i].last())
        t[i + 1] = t[i + 1].slice(0 until j).toMutableList()
    }
    if (t[n - 1].isNotEmpty()) ans++
    println(ans)
}

