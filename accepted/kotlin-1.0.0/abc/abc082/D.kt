fun main(args: Array<String>) {
    val s = readLine()!!
    val (xt, yt) = readLine()!!.split(' ').map { it.toInt() }

    val dx = mutableListOf<Int>()
    val dy = mutableListOf<Int>()
    s.split('T').forEachIndexed { i, sub ->
        if (i % 2 == 0) dx.add(sub.length) else dy.add(sub.length)
    }

    val x = dx.slice(1 until dx.size).sortedDescending()
            .fold(xt - dx[0]) { acc, i -> acc + if (acc > 0) -i else i }

    val y = dy.sortedDescending()
            .fold(yt) { acc, i -> acc + if (acc > 0) -i else i }

    println(if (x == 0 && y == 0) "Yes" else "No")
}

