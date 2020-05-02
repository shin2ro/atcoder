fun main() {
    val mod = 2019
    val s = readLine()!!.reversed()
    val n = s.length

    val a = IntArray(n)
    var x = 1
    for (i in 0 until n) {
        a[i] = (s[i] - '0') * x % mod
        x = x * 10 % mod
    }

    val cs = IntArray(n + 1)
    for (i in 0 until n) {
        cs[i + 1] = (cs[i] + a[i]) % mod
    }

    var ans = 0L
    val cnt = IntArray(2019)
    for (i in 0..n) {
        ans += cnt[cs[i]]++
    }
    println(ans)
}
