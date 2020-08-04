fun main() {
    val n = readLine()!!.toInt()
    val (d, x) = readLine()!!.split(' ').map { it.toInt() }
    val s = (0 until n)
            .map {
                val a = readLine()!!.toInt()
                (d - 1) / a + 1
            }
            .sum()
    println(s + x)
}

