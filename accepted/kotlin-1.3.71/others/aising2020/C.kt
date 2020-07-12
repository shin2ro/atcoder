fun main() {
    val t = IntArray(10001)
    fun init() {
        for (x in 1..100) {
            for (y in 1..100) {
                for (z in 1..100) {
                    val i = x * x + y * y + z * z + x * y + y * z + x * z
                    if (i < t.size) t[i]++
                }
            }
        }
    }
    init()

    val n = readLine()!!.toInt()

    val ans = (1..n)
            .map { t[it] }
            .joinToString("\n")

    println(ans)
}
