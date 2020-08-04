fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }.sorted()
    val set = mutableSetOf<Int>()
    var ans = 0
    for ((idx, v) in a.withIndex()) {
        var divisible = true

        if (idx + 1 < n && v == a[idx + 1]) {
            divisible = false
        }

        var i = 1
        while (divisible && i * i <= v) {
            if (v % i == 0) {
                if (set.contains(i) || set.contains(v / i)) {
                    divisible = false
                }
            }
            i++
        }

        if (divisible) ans++
        set.add(v)
    }
    println(ans)
}

