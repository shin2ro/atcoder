fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val dp = IntArray(50) { 1 }
    for (i in 0 until k) {
        dp[i + 2] = dp[i + 1] + dp[i]
    }
    println("${dp[k + 1]} ${dp[k]}")
}

