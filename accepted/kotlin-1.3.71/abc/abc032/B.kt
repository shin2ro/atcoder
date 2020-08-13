fun main() {
    val s = readLine()!!
    val n = readLine()!!.toInt()
    val ans = mutableSetOf<String>()

    for (i in 0 until s.length - n + 1) {
        ans.add(s.slice(i until i + n))
    }

    println(ans.size)
}

