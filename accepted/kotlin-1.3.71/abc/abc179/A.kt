fun main() {
    val s = readLine()!!
    println(s + if (s.last() == 's') "es" else "s")
}

