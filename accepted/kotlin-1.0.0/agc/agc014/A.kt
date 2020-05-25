fun main(args: Array<String>) {
    fun f(a: Int, b: Int, c: Int): Int {
        if (a % 2 == 1 || b % 2 == 1 || c % 2 == 1) return 0
        if (a == b && b == c) return -1
        return f((a + b) / 2, (b + c) / 2, (c + a) / 2) + 1
    }

    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    println(f(a, b, c))
}
