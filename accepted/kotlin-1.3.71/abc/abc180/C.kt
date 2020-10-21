fun main() {
    val n = readLine()!!.toLong()
    val ans = mutableListOf<Long>()
    var i = 1L
    while (i * i < n) {
        if (n % i == 0L) {
            ans.add(i)
            ans.add(n / i)
        }
        i++
    }
    if (i * i == n) {
        ans.add(i)
    }
    println(ans.sorted().joinToString("\n"))
}

