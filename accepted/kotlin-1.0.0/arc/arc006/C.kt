fun <T> List<T>.lowerBound(element: T): Int where T : Comparable<T> {
    return this
        .binarySearch { if (it >= element) 1 else -1 }
        .let { -(it + 1) }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    repeat(n) {
        val w = readLine()!!.toInt()
        val l = list.lowerBound(w)

        if (l == list.size) {
            list.add(w)
        } else {
            list[l] = w
        }
    }

    println(list.size)
}
