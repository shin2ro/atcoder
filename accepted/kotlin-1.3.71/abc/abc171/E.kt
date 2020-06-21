fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = a.reduce { acc, i -> acc xor i }
    println(a.map { b xor it }.joinToString(" "))
}
