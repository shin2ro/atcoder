class ModInt(x: Long) {

    companion object {
        const val MOD = 1e9.toLong() + 7
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

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { ModInt(it.toLong()) }

    fun f(n: ModInt): ModInt {
        var x = ModInt(1L)
        for (l in 2L..n.x) x *= ModInt(l)
        return x
    }

    val ans = when {
        n == m -> f(n) * f(m) * ModInt(2L)
        Math.abs(n.x - m.x) == 1L -> f(n) * f(m)
        else -> ModInt(0L)
    }

    println(ans)
}

