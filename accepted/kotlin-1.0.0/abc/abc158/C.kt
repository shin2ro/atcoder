fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }

    val x = (a * 100 + 7) / 8
    if (x / 10 == b) {
        println(x)
        return
    }

    val y = b * 10
    if (y * 8 / 100 == a) {
        println(y)
        return
    }

    println(-1)
}
