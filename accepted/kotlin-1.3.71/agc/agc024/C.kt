fun main() {
    val n = readLine()!!.toInt()
    val a = (0 until n).map { readLine()!!.toInt() }

    val ans = when {
        a[0] > 0 -> -1
        (1 until n).any { i -> a[i] - a[i - 1] > 1 } -> -1
        else -> {
            var ans = 0L
            for (i in 1 until n) {
                if (a[i] == a[i - 1] + 1) {
                    ans++
                } else {
                    ans += a[i]
                }
            }
            ans
        }
    }

    println(ans)
}

