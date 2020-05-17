fun main() {
    val k = readLine()!!.toInt()
    val s = readLine()!!
    println(if (s.length <= k) s else s.slice(0 until k) + "...")
}
