fun main(args: Array<String>) {
    val initials = mapOf(
            'M' to 0,
            'A' to 1,
            'R' to 2,
            'C' to 3,
            'H' to 4
    )
    val n = readLine()!!.toInt()
    val cnt = LongArray(5)
    repeat(n) {
        val s = readLine()!!
        if (s[0] in initials) {
            val i = initials[s[0]] ?: error("")
            cnt[i]++
        }
    }

    var ans = 0L

    for (i in 0..2) {
        for (j in i + 1..3) {
            for (k in j + 1..4) {
                ans += cnt[i] * cnt[j] * cnt[k]
            }
        }
    }

    println(ans)
}

