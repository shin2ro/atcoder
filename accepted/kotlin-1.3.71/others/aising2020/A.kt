fun main() {
    val (l, r, d) = readLine()!!.split(' ').map { it.toInt() }
    println((l..r).count { it % d == 0 })
}

