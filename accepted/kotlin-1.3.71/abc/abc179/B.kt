fun main() {
    val n = readLine()!!.toInt()
    val dices = (0 until n).map {
        val (d1, d2) = readLine()!!.split(' ').map { it.toInt() }
        d1 to d2
    }
    val ans = (0 until n - 2).any { i ->
        dices.slice(i..i + 2).all { (d1, d2) -> d1 == d2 }
    }
    println(if (ans) "Yes" else "No")
}

