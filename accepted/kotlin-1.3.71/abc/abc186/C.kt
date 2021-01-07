fun main() {
    val n = readLine()!!.toInt()
    var ans = 0
    for (i in 1..n) {
        val xs = listOf(i.toString(), i.toString(8))
        if (xs.all { !it.contains('7') }) {
            ans++
        }
    }
    println(ans)
}

