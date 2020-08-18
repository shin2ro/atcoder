fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val yd = Array(n + 1) { mutableListOf<Int>() }
    val py = (0 until m).map {
        val (p, y) = readLine()!!.split(' ').map { it.toInt() }
        yd[p].add(y)
        p to y
    }
    yd.forEach { it.sort() }

    val ans = py
            .joinToString("\n") { (p, y) ->
                p.toString().padStart(6, '0') +
                        (yd[p].binarySearch(y) + 1).toString().padStart(6, '0')
            }
    println(ans)
}

