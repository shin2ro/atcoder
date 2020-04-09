fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = IntArray(n + 1)
    repeat(n) {
        a[it + 1] = readLine()!!.toInt()
    }

    val visited = IntArray(n + 1) { -1 }
    visited[1] = 0

    var cur = 1
    while (true) {
        val next = a[cur]
        if (visited[next] != -1) break
        visited[next] = visited[cur] + 1
        cur = next
    }

    println(visited[2])
}
