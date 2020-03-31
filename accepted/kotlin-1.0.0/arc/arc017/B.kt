fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val a = (0 until n).map { readLine()!!.toInt() }.toIntArray() + IntArray(1)
    var ans = 0
    var cur = 0
    for (i in 1..n) {
        if (a[i] <= a[i - 1]) {
            ans += Math.max(i - cur - k + 1, 0)
            cur = i
        }
    }
    println(ans)
}
