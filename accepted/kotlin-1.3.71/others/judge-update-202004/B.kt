fun main() {
    val n = readLine()!!.toInt()
    val r = mutableListOf<Int>()
    val b = mutableListOf<Int>()
    repeat(n) {
        val (x, c) = readLine()!!.split(' ')
        if (c == "R") {
            r.add(x.toInt())
        } else {
            b.add(x.toInt())
        }
    }

    println((r.sorted() + b.sorted()).joinToString("\n"))
}

