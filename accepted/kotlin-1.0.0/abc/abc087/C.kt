fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = (0 until 2).map { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }.toTypedArray()
    var ans = 0
    for (k in 0 until n) {
        var cnt = 0
        var i = 0
        for (j in 0 until n) {
            cnt += a[i][j]
            if (j == k) {
                i++
                cnt += a[i][j]
            }
        }
        ans = Math.max(cnt, ans)
    }
    println(ans)
}
