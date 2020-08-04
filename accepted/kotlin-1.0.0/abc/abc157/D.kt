class UnionFind(n: Int) {
    private val par = IntArray(n) { -1 }
    fun find(x: Int): Int {
        if (par[x] < 0) return x
        par[x] = find(par[x])
        return par[x]
    }
    fun unite(x: Int, y: Int) {
        val (rx, ry) = run {
            val rx = find(x)
            val ry = find(y)
            if (rx > ry) ry to rx else rx to ry
        }
        if (rx == ry) return
        par[rx] += par[ry]
        par[ry] = rx
    }
    fun same(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
    fun size(x: Int): Int {
        return -par[find(x)]
    }
}

fun main(args: Array<String>) {
    val (n, m, k) = readLine()!!.split(' ').map { it.toInt() }
    val uf = UnionFind(n + 1)
    val fs = IntArray(n + 1)
    val bs = IntArray(n + 1)

    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        fs[a]++
        fs[b]++
        uf.unite(a, b)
    }

    repeat(k) {
        val (c, d) = readLine()!!.split(' ').map { it.toInt() }
        if (uf.same(c, d)) {
            bs[c]++
            bs[d]++
        }
    }

    val ans = (1..n)
            .map { uf.size(it) -1 - fs[it] - bs[it] }
            .joinToString(" ")

    println(ans)
}

