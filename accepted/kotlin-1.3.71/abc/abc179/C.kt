fun main() {
    val n = readLine()!!.toInt()
    println((1 until n).map { a -> (n - 1) / a }.sum())
}

