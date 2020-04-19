fun main() {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun gcd(a: Int, b: Int, c: Int): Int {
        return gcd(gcd(a, b), c)
    }

    val k = readLine()!!.toInt()
    var ans = 0L
    for (a in 1..k) {
        for (b in 1..k) {
            for (c in 1..k) {
                ans += gcd(a, b, c)
            }
        }
    }
    println(ans)
}
