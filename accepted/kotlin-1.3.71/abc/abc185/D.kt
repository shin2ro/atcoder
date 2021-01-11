fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val a = readLine()!!.let {
        if (it.isEmpty()) {
            emptyList()
        } else {
            it.split(' ').map { it.toInt() }.sorted()
        }
    }
    val b = mutableListOf<Int>()

    var cur = 0
    for (i in 0 until m) {
        val x = a[i] - cur - 1
        if (x > 0) {
            b.add(x)
        }
        cur = a[i]
    }
    if (n - cur > 0) {
        b.add(n - cur)
    }

    val k = b.min() ?: 0
    println(if (k == 0) 0 else b.sumBy { (it + k - 1) / k })
}

