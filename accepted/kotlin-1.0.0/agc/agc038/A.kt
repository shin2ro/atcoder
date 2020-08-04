fun main(args: Array<String>) {
    val (h, w, a, b) = readLine()!!.split(' ').map { it.toInt() }
    val s1 = "0".repeat(a) + "1".repeat(w - a)
    val s2 = "1".repeat(a) + "0".repeat(w - a)
    val ans = (0 until h).joinToString("\n") { if (it < b) s1 else s2 }
    println(ans)
}

