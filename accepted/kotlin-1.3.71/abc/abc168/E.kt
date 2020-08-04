class ModInt(x: Long) {

    companion object {
        const val MOD = 1e9.toLong() + 7
    }

    val x = (x % MOD + MOD) % MOD

    operator fun plus(other: ModInt): ModInt {
        return ModInt(x + other.x)
    }

    operator fun plus(other: Long): ModInt {
        return this + ModInt(other)
    }

    operator fun minus(other: ModInt): ModInt {
        return ModInt(x - other.x)
    }

    operator fun minus(other: Long): ModInt {
        return this - ModInt(other)
    }

    operator fun times(other: ModInt): ModInt {
        return ModInt(x * other.x)
    }

    operator fun times(other: Long): ModInt {
        return this * ModInt(other)
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

    fun pow(exp: Int): ModInt {
        return pow(exp.toLong())
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

fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

fun main() {
    val n = readLine()!!.toInt()
    var zero = 0L
    val cnt = mutableMapOf<Pair<Long, Long>, Pair<Int, Int>>()
    repeat(n) {
        var (a, b) = readLine()!!.split(' ').map { it.toLong() }
        if (a == 0L && b == 0L) {
            zero++
            return@repeat
        }

        val g = gcd(a, b)
        a /= g
        b /= g
        if (a < 0) {
            a = -a
            b = -b
        }
        if (b > 0) {
            cnt[a to b] = (cnt[a to b] ?: 0 to 0).let { (a, b) -> a + 1 to b }
        } else {
            cnt[-b to a] = (cnt[-b to a] ?: 0 to 0).let { (a, b) -> a to b + 1 }
        }
    }

    var ans = ModInt(1L)

    val base = ModInt(2)
    for (key in cnt.keys) {
        val (c1, c2) = cnt[key]!!
        ans *= base.pow(c1) - 1 + base.pow(c2) - 1 + 1
    }
    ans -= 1
    ans += zero

    println(ans)
}

