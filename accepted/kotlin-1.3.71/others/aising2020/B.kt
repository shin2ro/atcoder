fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    println(a.withIndex().count { (i, v) -> i % 2 == 0 && v % 2 == 1 })
}

