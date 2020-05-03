fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val ss = IntArray(n)

    repeat(k) {
        val d = readLine()!!.toInt()
        val a = readLine()!!.split(' ').map { it.toInt() - 1 }
        for (i in a) {
            ss[i]++
        }
    }

    println(ss.filter { it == 0 }.count())
}
