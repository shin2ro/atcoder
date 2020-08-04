fun main() {
    val n = readLine()!!.toInt()
    val a = IntArray(n + 1)
    readLine()!!.split(' ').map { it.toInt() }.forEach { a[it]++ }
    println(a.slice(1..n).joinToString("\n"))
}

