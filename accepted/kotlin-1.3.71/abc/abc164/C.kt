fun main() {
    val n = readLine()!!.toInt()
    val set = mutableSetOf<String>()
    repeat(n) {
        val s = readLine()!!
        set.add(s)
    }
    println(set.size)
}
