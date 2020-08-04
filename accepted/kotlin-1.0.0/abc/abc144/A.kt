fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(if (a in 1..9 && b in 1..9) a * b else -1)
}

