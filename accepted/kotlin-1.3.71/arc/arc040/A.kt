fun main() {
    val n = readLine()!!.toInt()
    var r = 0
    var b = 0
    repeat(n) {
        val s = readLine()!!
        for (c in s) {
            if (c == 'R') r++
            if (c == 'B') b++
        }
    }
    val ans = when {
        r > b -> "TAKAHASHI"
        r < b -> "AOKI"
        else -> "DRAW"
    }
    println(ans)
}

