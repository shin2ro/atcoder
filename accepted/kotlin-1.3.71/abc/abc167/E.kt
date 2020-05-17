class ModInt(x: Long) {

    companion object {
        const val MOD = 998244353L
    }

    val x = (x % MOD + MOD) % MOD

    operator fun plus(other: ModInt): ModInt {
        return ModInt(x + other.x)
    }

    operator fun minus(other: ModInt): ModInt {
        return ModInt(x - other.x)
    }

    operator fun times(other: ModInt): ModInt {
        return ModInt(x * other.x)
    }

    operator fun div(other: ModInt): ModInt {
        return this * other.inv()
    }

    fun pow(exp: Long): ModInt {
        if (exp == 0L) return ModInt(1L)
        var a = pow(exp shr 1)
        a *= a
        if (exp and 1L == 0L) return a
        return this * a
    }

    fun inv(): ModInt {
        return this.pow(MOD - 2)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ModInt

        if (x != other.x) return false

        return true
    }

    override fun hashCode(): Int {
        return x.hashCode()
    }

    override fun toString(): String {
        return "$x"
    }

}

class Comb(n: Int) {

    companion object {
        const val MOD = ModInt.MOD
    }

    private val fact = LongArray(n + 1)
    private val factInv = LongArray(n + 1)

    init {
        fact[0] = 1L
        for (i in 1..n) {
            fact[i] = fact[i - 1] * i % MOD
        }
        factInv[n] = ModInt(fact[n]).inv().x
        for (i in n downTo 1) {
            factInv[i - 1] = factInv[i] * i % MOD
        }
    }

    fun comb(n: Int, k: Int): Long {
        if (k !in 0..n) return 0L
        return fact[n] * factInv[k] % MOD * factInv[n - k] % MOD
    }

}

fun main() {
    val cb = Comb(200000)
    val (n, m, k) = run {
        val (n, m, k) = readLine()!!.split(' ').map { it.toInt() }
        Triple(n, m.toLong(), k)
    }

    var ans = ModInt(0L)
    for (i in 0..k) {
        val x1 = ModInt(cb.comb(n - 1, n - 1 - i))
        val x2 = ModInt(m) * ModInt(m - 1).pow((n - 1 - i).toLong())
        ans += x1 * x2
    }
    println(ans)
}
