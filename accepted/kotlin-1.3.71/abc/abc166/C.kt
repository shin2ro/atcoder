fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val hs = readLine()!!.split(' ').map { it.toInt() }
    val ans = BooleanArray(n) { true }
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() - 1 }

        when {
            hs[a] > hs[b] -> {
                ans[b] = false
            }
            hs[a] < hs[b] -> {
                ans[a] = false
            }
            else -> {
                ans[a] = false
                ans[b] = false
            }
        }
    }
    println(ans.count { it })
}
