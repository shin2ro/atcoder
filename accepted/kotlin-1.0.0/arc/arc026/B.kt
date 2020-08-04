fun main(args: Array<String>) {
    val n = readLine()!!.toLong()

    var s = 0L
    var i = 1L
    while (i * i <= n) {
        if (n % i == 0L) {
            s += i
            if (i != n / i) s += n / i
        }
        i++
    }

    val ans = when {
        s == n * 2 -> "Perfect"
        s < n * 2 -> "Deficient"
        else -> "Abundant"
    }

    println(ans)
}

